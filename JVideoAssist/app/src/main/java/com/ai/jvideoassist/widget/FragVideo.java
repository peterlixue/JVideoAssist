package com.ai.jvideoassist.widget;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ai.jvideoassist.R;
import com.ai.jvideoassist.adapter.NodePlayAdapter;
import com.ai.jvideoassist.config.AppConfig;
import com.ai.jvideoassist.inter.IVideoIndex;
import com.ai.jvideoassist.inter.OnItemOptListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class FragVideo extends Fragment implements FragSetting.SettingChangeCallBack {

    private final String TAG = AppConfig.TAG + this.getClass().getSimpleName();

    private final String Description = "测试recycleview自定义2行2列,使用开源NodePlayer来同时播放RTSP流媒体";

    private static final int ShowCol = 2;
    private final int ShowRow = 2;


    private RecyclerView recyclerView;
    private Context mContext;

    private List<String> mStreamUrls;

    private HashMap<Integer, String> mPlayUrls;
    private NodePlayAdapter mRecycleAdapter;
    private boolean mFullScreenMode;
    private boolean mFirstPlay = true;

    private RecyclerView mFullRecView;
    private HashMap<Integer, String> mFullUrls;
    private NodePlayAdapter mFullAdapter;

    public FragVideo() {
        mFullScreenMode = false;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);

        Log.d(TAG, " onCreateView begin");

        mContext = view.getContext();
        recyclerView = view.findViewById(R.id.video_recycle_view);
        //recyclerView.getViewTreeObserver().addOnGlobalLayoutListener

        //gridlayout setting
        GridLayoutManager gridLayoutManagerCol = new GridLayoutManager(mContext, ShowCol);
        gridLayoutManagerCol.setOrientation(GridLayoutManager.VERTICAL);  //默认设置
        recyclerView.setLayoutManager(gridLayoutManagerCol);


        GridLayoutManager gridLayoutManagerRow = new GridLayoutManager(mContext, ShowRow);
        gridLayoutManagerRow.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManagerRow);


        DividerItemDecoration dividerVertical = new DividerItemDecoration(mContext, RecyclerView.VERTICAL);
        dividerVertical.setDrawable(mContext.getResources().getDrawable(R.drawable.shape_item_decoration));
        recyclerView.addItemDecoration(dividerVertical);

        DividerItemDecoration dividerHorizontal = new DividerItemDecoration(mContext, RecyclerView.HORIZONTAL);
        dividerHorizontal.setDrawable(mContext.getResources().getDrawable(R.drawable.shape_item_decoration));
        recyclerView.addItemDecoration(dividerHorizontal);

        mFullScreenMode = false;
        mFullRecView = view.findViewById(R.id.video_fullRecview);
        mFullRecView.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        mFullRecView.setVisibility(View.INVISIBLE);
        //data created
        mPlayUrls = new HashMap<>();
        mFullUrls = new HashMap<>();


        //load data List and load data with appConfig play mode
        loadData();

        //bind view and adapter
        bindViewAdapter();

        Toast.makeText(mContext, "获取视频播放数据中...", Toast.LENGTH_SHORT).show();
        //view.setVisibility(View.INVISIBLE);
        Log.d(TAG, " onCreateView over");
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, " onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, " onStop");
        //停止显示
        //mRecycleAdapter.getItemCount()
    }

    @Override
    public void onResume() {

        super.onResume();
        Log.d(TAG, " onResume");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, " Begin onDestroy");
        mRecycleAdapter.stopALl();
        mFullAdapter.stopALl();

        mRecycleAdapter.realeaseAll();
        mFullAdapter.realeaseAll();

        Log.d(TAG, " onDestroy");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint:" + isVisibleToUser);
        if (recyclerView == null || mFullAdapter == null || mRecycleAdapter == null)
            return;
        if (isVisibleToUser) {
            if (mFullScreenMode) {
                mFullAdapter.startPlayerAll();
            } else {
                mRecycleAdapter.startPlayerAll();
            }
        } else {
            mFullAdapter.puaseALl();
            mRecycleAdapter.puaseALl();
        }

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged:" + hidden);
    }


    private void loadData() {

        Log.d(TAG, "loadData");


        mPlayUrls.put(IVideoIndex.VIDEO1, AppConfig.getIns().mVideoURL01);
        mPlayUrls.put(IVideoIndex.VIDEO2, AppConfig.getIns().mVideoURL02);
        mPlayUrls.put(IVideoIndex.VIDEO3, AppConfig.getIns().mVideoURL03);
        mPlayUrls.put(IVideoIndex.VIDEO4, AppConfig.getIns().mVideoURL04);


        mFullUrls.put(IVideoIndex.VIDEO1, AppConfig.getIns().mVideoURL01);

    }

    private void bindViewAdapter() {

        Log.d(TAG, "bindViewAdapter");

        mRecycleAdapter = new NodePlayAdapter(mPlayUrls, mContext);

        //计算item中的宽高
        mRecycleAdapter.init(ShowRow, ShowCol);
        recyclerView.setAdapter(mRecycleAdapter);

        mRecycleAdapter.setOnItemOptListener(new OnItemOptListener() {
            @Override
            public void onItemTouch(View view, int position) {

            }

            @Override
            public void onItemDoubleClick(View view, int position) {

                // mRecycleAdapter.enterFullMode(view, position);
                Toast.makeText(mContext, ",进入全屏,双击了View" + position, Toast.LENGTH_SHORT).show();
                enterFullMode(view, position);
                mFullScreenMode = true;
            }

            @Override
            public void onStartPlay() {
                delayStartPlay();
            }
        });


        mFullAdapter = new NodePlayAdapter(mFullUrls, mContext);
        mFullAdapter.init(1, 1);
        mFullRecView.setAdapter(mFullAdapter);
        mFullAdapter.setOnItemOptListener(new OnItemOptListener() {
            @Override
            public void onItemTouch(View view, int position) {

            }

            @Override
            public void onItemDoubleClick(View view, int position) {

                Toast.makeText(mContext, "退出全屏,双击了View" + position, Toast.LENGTH_SHORT).show();
                exitFullMode(view, position);
                mFullScreenMode = false;

            }

            @Override
            public void onStartPlay() {

            }
        });
    }

    private void delayStartPlay() {

        Log.d(TAG,"启动延时播放...");
        if (mFirstPlay) {
            if (mRecycleAdapter.bindDataCount() >= mPlayUrls.size()) {

                Timer timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mRecycleAdapter.startPlayerAll();
                    }
                }, 2000);
                mFirstPlay = false;
            }
        }


    }

    public void enterFullMode(View v, int position) {

        mRecycleAdapter.puaseALl();
        recyclerView.setVisibility(View.INVISIBLE);

        mFullRecView.setVisibility(View.VISIBLE);
        mFullAdapter.updatePlayUrl(0, NodePlayAdapter.getURLFromPosition(position));
        mFullAdapter.startPlayerAll();
        Log.d(TAG, "enter enterFullMode");

    }

    public void exitFullMode(View v, int position) {

        mFullAdapter.puaseALl();
        recyclerView.setVisibility(View.VISIBLE);
        mFullRecView.setVisibility(View.INVISIBLE);
        mRecycleAdapter.startPlayerAll();

        Log.d(TAG, "enter exitFullMode");
    }


    @Override
    public void onSettingChanged(ArrayList<Integer> videoIndexs) {
        if (videoIndexs.isEmpty()) {
            return;
        }
        //处理对应的播放地址变化
        for (Integer index : videoIndexs) {
            mRecycleAdapter.updatePlayUrl(index);
        }
    }
}
