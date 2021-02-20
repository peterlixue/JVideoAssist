package com.ai.jvideoassist;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class FragThird extends Fragment {

    private  final String TAG = this.getClass().getSimpleName();

    private  final String Description = "测试recycleview自定义2行2列,使用开源NodePlayer来同时播放RTSP流媒体";

    private static final int ShowCol = 2;
    private final int ShowRow = 2;

    private RecyclerView recyclerView;
    private Context mContext;

    private List<String> mStreamUrls;
    private NodePlayAdapter mRecycleAdapter;

    public FragThird() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);

        Log.d(TAG, " onCreateView begin");

        mContext = view.getContext();
        recyclerView = view.findViewById(R.id.video_recycle_view);

        //gridlayout setting
        GridLayoutManager gridLayoutManagerCol = new GridLayoutManager(mContext, ShowCol);
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


        //load data List and load data with appConfig play mode
        loadData();

        //bind view and adapter
        bindViewAdapter();

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


        Log.d(TAG, " onDestroy");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG,"setUserVisibleHint:" + isVisibleToUser);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG,"onHiddenChanged:" + hidden);
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

        mRecycleAdapter = new NodePlayAdapter(mStreamUrls, mContext);
        recyclerView.setAdapter(mRecycleAdapter);

    }
}
