package com.ai.jvideoassist.widget;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.ai.jvideoassist.R;
import com.ai.jvideoassist.config.AppConfig;


public class FragSetting extends Fragment {

    private final String TAG = AppConfig.TAG + this.getClass().getSimpleName();

    private final String Description = "测试recycleview自定义2行2列,使用开源NodePlayer来同时播放RTSP流媒体";


    private Context mContext;

    public FragSetting() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_setting, container, false);

        Log.d(TAG, " onCreateView begin");

        mContext = view.getContext();



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

        Log.d(TAG, " onDestroy");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint:" + isVisibleToUser);


    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged:" + hidden);
    }



}
