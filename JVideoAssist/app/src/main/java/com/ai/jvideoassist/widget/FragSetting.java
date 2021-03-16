package com.ai.jvideoassist.widget;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ai.jvideoassist.R;
import com.ai.jvideoassist.config.AppConfig;

import java.util.ArrayList;

import static com.ai.jvideoassist.MainActivity.PAGE_ONE;


public class FragSetting extends Fragment {

    private final String TAG = AppConfig.TAG + this.getClass().getSimpleName();

    private final String Description = "测试recycleview自定义2行2列,使用开源NodePlayer来同时播放RTSP流媒体";


    private Context mContext;

    private EditText    mTxtVideo01;
    private EditText    mTxtVideo02;
    private EditText    mTxtVideo03;
    private EditText    mTxtVideo04;

    private Button      mBtnSave;
    private Button      mBtnDefault;

    public FragSetting() {

    }

    public interface SettingChangeCallBack {
        public void onSettingChanged(ArrayList<Integer> videoIndexs);
    }

    private SettingChangeCallBack   mSettingCall;

    public void setSettingChangeCallBack(SettingChangeCallBack tcallback) {
        mSettingCall = tcallback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_setting, container, false);

        Log.d(TAG, " onCreateView begin");

        mContext = view.getContext();
        mTxtVideo01 = view.findViewById(R.id.setting_edittxt_01);
        mTxtVideo02 = view.findViewById(R.id.setting_edittxt_02);
        mTxtVideo03 = view.findViewById(R.id.setting_edittxt_03);
        mTxtVideo04 = view.findViewById(R.id.setting_edittxt_04);

        mTxtVideo01.setText(AppConfig.getIns().mVideoURL01);
        mTxtVideo02.setText(AppConfig.getIns().mVideoURL02);
        mTxtVideo03.setText(AppConfig.getIns().mVideoURL03);
        mTxtVideo04.setText(AppConfig.getIns().mVideoURL04);

        mBtnSave = view.findViewById(R.id.buttonSave);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"更新了保存的相机播放地址",Toast.LENGTH_SHORT).show();
                checkSettingChange(false);
            }
        });
        mBtnDefault = view.findViewById(R.id.buttonDefault);
        mBtnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"恢复默认的相机播放地址",Toast.LENGTH_SHORT).show();
                checkSettingChange(true);
                mTxtVideo01.setText(AppConfig.getIns().mVideoURLDefault);
                mTxtVideo02.setText(AppConfig.getIns().mVideoURLDefault);
                mTxtVideo03.setText(AppConfig.getIns().mVideoURLDefault);
                mTxtVideo04.setText(AppConfig.getIns().mVideoURLDefault);

            }
        });

        Log.d(TAG, " onCreateView over");
        return view;
    }

    private void checkSettingChange(boolean bDefault) {

        ArrayList<Integer>  videos = new ArrayList<Integer>();
        if (bDefault)
        {
            if (mTxtVideo01.getText().toString() != AppConfig.getIns().mVideoURLDefault)
            {
                videos.add(1);
            }
            if (mTxtVideo02.getText().toString() != AppConfig.getIns().mVideoURLDefault)
            {
                videos.add(2);

            }
            if (mTxtVideo03.getText().toString() != AppConfig.getIns().mVideoURLDefault)
            {
                videos.add(3);

            }
            if (mTxtVideo04.getText().toString() != AppConfig.getIns().mVideoURLDefault)
            {
                videos.add(4);

            }
        }
        else
        {
            if (mTxtVideo01.getText().toString() != AppConfig.getIns().mVideoURL01)
            {
                videos.add(1);
                AppConfig.getIns().mVideoURL01 = mTxtVideo01.getText().toString();
            }
            if (mTxtVideo02.getText().toString() != AppConfig.getIns().mVideoURL02)
            {
                videos.add(2);
                AppConfig.getIns().mVideoURL02 = mTxtVideo02.getText().toString();
            }
            if (mTxtVideo03.getText().toString() != AppConfig.getIns().mVideoURL03)
            {
                videos.add(3);
                AppConfig.getIns().mVideoURL03 = mTxtVideo03.getText().toString();
            }
            if (mTxtVideo04.getText().toString() != AppConfig.getIns().mVideoURL04)
            {
                videos.add(4);
                AppConfig.getIns().mVideoURL04 = mTxtVideo04.getText().toString();
            }
        }




        if (mSettingCall != null)
        {
            mSettingCall.onSettingChanged(videos);
        }

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
