package com.ai.jvideoassist;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class FragFirst extends Fragment {

    private static final String TAG = "FragFirst";

    private int mGridCol;
    private int mGridRow;
    private int mGridMaxNum;

    private RecyclerView recyclerView;
    private Context mContext;

    private List<String> mTxtList;
    private RecycleAdapter mRecycleAdapter;

    private List<LocalMovieBean> mMovieList;
    private LocalMovieAdapter    mMovieAdapter;

    public FragFirst() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate begin");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);

        Log.d(TAG,"onCreateView begin");

        //1. caclulate the vide num to be showed with the app config values
        calcGridNumber(AppConfig.getIns().mVideoNum, AppConfig.getIns().mVideMaxNum);

        //2.add sub view in the recyleview with the cfg info
        mContext = view.getContext();
        recyclerView = view.findViewById(R.id.video_recycle_view);

        //gridlayout setting
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(mContext,mGridCol);
        recyclerView.setLayoutManager(gridLayoutManager);

        DividerItemDecoration dividerVertical = new DividerItemDecoration(mContext, RecyclerView.VERTICAL);
        dividerVertical.setDrawable(mContext.getResources().getDrawable(R.drawable.shape_item_decoration));
        recyclerView.addItemDecoration(dividerVertical);

        DividerItemDecoration dividerHorizontal = new DividerItemDecoration(mContext, RecyclerView.HORIZONTAL);
        dividerHorizontal.setDrawable(mContext.getResources().getDrawable(R.drawable.shape_item_decoration));
        recyclerView.addItemDecoration(dividerHorizontal);

        //data list new
        mTxtList = new ArrayList<>();
        mMovieList = new ArrayList<>();

        //other object new
        mMovieAdapter = new LocalMovieAdapter(mContext, mMovieList);
        mRecycleAdapter = new RecycleAdapter(mTxtList, mContext);

        if (checkAndRequestPermission()) {
            //load data List and load data with appConfig play mode
            loadData();

            //bind view and adapter
            bindViewAdapter();
        }


        Log.d(TAG,"onCreateView over");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG,"onStart begin ");
        //frefresh gird split item
        calcGridNumber(AppConfig.getIns().mVideoNum, AppConfig.getIns().mVideMaxNum);

        GridLayoutManager layoutManager = (GridLayoutManager)recyclerView.getLayoutManager();
        if (layoutManager != null)
        {
            layoutManager.setSpanCount(mGridCol);
        }


        Log.d(TAG,"onStart over");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mMovieAdapter != null) {
            mMovieAdapter.destroyPlayer();
        }


        Log.d(TAG,"onDestroy");
    }

    public boolean checkAndRequestPermission( ) {

        if (Build.VERSION.SDK_INT >= 23)
        {
            int permission_write = ContextCompat.checkSelfPermission(mContext,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int permission_read = ContextCompat.checkSelfPermission(mContext,
                    Manifest.permission.READ_EXTERNAL_STORAGE);
            if (permission_write != PackageManager.PERMISSION_GRANTED
                    || permission_read != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(mContext, "正在请求权限", Toast.LENGTH_SHORT).show();
                //申请权限，特征码自定义为1，可在回调时进行相关判断
                ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
            else {
                Toast.makeText(mContext, "读写权限已经开通", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;

        }
        return true;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //权限已成功申请
                    Toast.makeText(mContext, "获取权限成功", Toast.LENGTH_SHORT).show();

                    //init data List and load data with appConfig play mode
                    loadData();

                    //bind view and adapter
                    bindViewAdapter();

                } else {
                    //用户拒绝授权
                    Toast.makeText(mContext, "无法获取SD卡读写权限", Toast.LENGTH_SHORT).show();

                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private void loadData(){

        Log.d(TAG,"loadData");

        int playmode = Integer.parseInt(AppConfig.getIns().mPlayMode);
        if (playmode == 1) //play local movie as test
        {
            loadMovieData();

            return;
        }
        if (playmode == 4)
        {
            mTxtList.clear();
            mTxtList.add("HOUSTON ROCKETS");
            mTxtList.add("LOSANGEL LAKERS");
            mTxtList.add("DALAS MAV");
            mTxtList.add("LOSANGEL CLIPPERS");
            mTxtList.add("DENVER NUGGETS");
            mTxtList.add("PORTLAND BLIZZARDS");

            return;
        }

    }

    private void bindViewAdapter() {

        Log.d(TAG,"bindViewAdapter");
        int playmode = Integer.parseInt(AppConfig.getIns().mPlayMode);
        if (playmode == 1) //play local movie as test
        {

            recyclerView.setAdapter(mMovieAdapter);
            mMovieAdapter.notifyDataSetChanged();

            return;
        }
        if (playmode == 4)
        {
            recyclerView.setAdapter(mRecycleAdapter);

            return;
        }
    }


    private void loadMovieData() {

        mMovieList.clear();
        List<LocalMovieBean> datalist = new ArrayList<>();
        ContentResolver resolver = mContext.getContentResolver();
        if (resolver == null)
        {
            Log.d(TAG,"resolver is null");
            return;
        }
        //content://media/external/video/media
        Uri videoUrl = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = resolver.query(videoUrl,null,null,null,null);
        if (cursor == null) {
            Log.d(TAG,"cursor is null,return this function");
            return;
        }
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME));
            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
            long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.DURATION));
            long size = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.SIZE));
            LocalMovieBean bean = new LocalMovieBean(name,path,duration,size);
            datalist.add(bean);
            //限制显示的数量
            if (datalist.size() > mGridMaxNum)
            {
                break;
            }
        }
        if (datalist.isEmpty()) {
            Log.d(TAG,"本地视频文件没有找到：" + videoUrl.toString());
        }
        else {
            Log.d(TAG,"共找到视频文件：" + datalist.size() + "个,目录：" + videoUrl.toString());
        }
        mMovieList.addAll(datalist);

    }

    private void calcGridNumber(String videonum, String videomaxnum) {
        mGridMaxNum = Integer.parseInt(videomaxnum);
        int tvNum = Integer.parseInt(videonum);
        if (tvNum > mGridMaxNum) {
            tvNum = mGridMaxNum;
        }

        //计算得到gridview控件的列和行
        switch (tvNum) {
            case 1:
                mGridRow = 1;
                mGridCol = 1;
                break;
            case 2:
                mGridRow = 1;
                mGridCol = 2;
                break;
            case 3:
            case 4:
                mGridRow = 2;
                mGridCol = 2;
                break;
            case 5:
            case 6:
                mGridRow = 2;
                mGridCol = 3;
                break;
            case 7:
            case 8:
                mGridRow = 2;
                mGridCol = 4;
                break;
            case 9:
                mGridRow = 3;
                mGridCol = 3;
            default:
                mGridRow = 2;
                mGridCol = 2;
        }
    }


}
