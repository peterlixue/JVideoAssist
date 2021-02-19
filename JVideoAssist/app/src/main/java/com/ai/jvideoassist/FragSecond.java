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
 *
 */
public class FragSecond extends Fragment {

    protected final String TAG = this.getClass().getSimpleName();

    private static final int ShowCol = 2;

    private RecyclerView recyclerView;
    private Context mContext;

    private List<String> mStreamUrls;
    private WebViewAdapter mRecycleAdapter;


    private String ip_addr = "192.168.0.1";
    private String port = "5001";

    public FragSecond() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "FragSecond onCreate begin");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);

        Log.d(TAG, "FragSecond onCreateView begin");

        //1. caclulate the vide num to be showed with the app config values


        //2.add sub view in the recyleview with the cfg info
        mContext = view.getContext();
        recyclerView = view.findViewById(R.id.video_recycle_view);

        //gridlayout setting
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(mContext, ShowCol);
        recyclerView.setLayoutManager(gridLayoutManager);

        DividerItemDecoration dividerVertical = new DividerItemDecoration(mContext, RecyclerView.VERTICAL);
        dividerVertical.setDrawable(mContext.getResources().getDrawable(R.drawable.shape_item_decoration));
        recyclerView.addItemDecoration(dividerVertical);

        DividerItemDecoration dividerHorizontal = new DividerItemDecoration(mContext, RecyclerView.HORIZONTAL);
        dividerHorizontal.setDrawable(mContext.getResources().getDrawable(R.drawable.shape_item_decoration));
        recyclerView.addItemDecoration(dividerHorizontal);


        //load data List and load data with appConfig play mode
        loadData();

        //bind view and adapter
        bindViewAdapter();


        Log.d(TAG, "FragSecond onCreateView over");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, "FragSecond onStart begin ");


        Log.d(TAG, "FragSecond onStart over");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "FragSecond onStop");
        //停止显示
        //mRecycleAdapter.getItemCount()
    }

    @Override
    public void onResume() {

        super.onResume();
        Log.d(TAG, "FragSecond onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();


        Log.d(TAG, "FragSecond onDestroy");
    }


    private void loadData() {

        Log.d(TAG, "loadData");

        mStreamUrls = new ArrayList<>();
        mStreamUrls.add("1");
        mStreamUrls.add("2");
        mStreamUrls.add("3");
        mStreamUrls.add("4");

    }

    private void bindViewAdapter() {

        Log.d(TAG, "bindViewAdapter");
        int playmode = Integer.parseInt(AppConfig.getIns().mPlayMode);

        mRecycleAdapter = new WebViewAdapter(mStreamUrls, mContext);
        recyclerView.setAdapter(mRecycleAdapter);

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG,"setUserVisibleHint:" + isVisibleToUser);
        if (mRecycleAdapter == null)
            return;
        if (isVisibleToUser)
        {
            mRecycleAdapter.loadData();
        }
        else
        {
            mRecycleAdapter.closeData();
        }

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG,"onHiddenChanged:" + hidden);
    }
}
