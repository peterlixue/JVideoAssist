package com.ai.jvideoassist.widget;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.ai.jvideoassist.R;
import com.ai.jvideoassist.config.AppConfig;
import com.ai.jvideoassist.inter.IVideoIndex;

import java.util.ArrayList;


public class FragSetting extends Fragment {

    private final String TAG = AppConfig.TAG + this.getClass().getSimpleName();

    private final String Description = "测试recycleview自定义2行2列,使用开源NodePlayer来同时播放RTSP流媒体";
    private final String LOCAL_TEST_ADDRESS1 = "rtsp://192.168.1.101:5540/live/1";

    private Context mContext;

    private EditText mTxtVideo01;
    private EditText mTxtVideo02;
    private EditText mTxtVideo03;
    private EditText mTxtVideo04;

    private Button mBtnSave;
    private Button mBtnDefault;
    private Button mBtnTest1;
    private Button mBtnTest2;

    private boolean mBDefault;

    public FragSetting() {

    }

    public interface SettingChangeCallBack {
        public void onSettingChanged(ArrayList<Integer> videoIndexs);
    }

    private SettingChangeCallBack mSettingCall;

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
                //Toast.makeText(mContext,"更新了保存的相机播放地址",Toast.LENGTH_SHORT).show();
                mBDefault = false;
                showAlertDlg();
            }
        });
        mBtnDefault = view.findViewById(R.id.buttonDefault);
        mBtnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext,"恢复默认的相机播放地址",Toast.LENGTH_SHORT).show();
                mBDefault = true;
                showAlertDlg();

            }
        });

        mBtnTest1 = view.findViewById(R.id.buttonTest1);
        mBtnTest2 = view.findViewById(R.id.buttonTest2);
        mBtnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTxtVideo01.setText("rtsp://192.168.1.101:5540/live/1");
                mTxtVideo02.setText("rtsp://192.168.1.101:5542/live/1");
                mTxtVideo03.setText("rtsp://192.168.1.101:5544/live/1");
                mTxtVideo04.setText("rtsp://192.168.1.101:5546/live/1");
            }
        });

        mBtnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTxtVideo01.setText("");
                mTxtVideo02.setText("");
                mTxtVideo03.setText("");
                mTxtVideo04.setText("");
            }
        });
        Log.d(TAG, " onCreateView over");
        return view;
    }

    private void checkSettingChange(boolean bDefault) {

        ArrayList<Integer> videos = new ArrayList<Integer>();
        if (bDefault) {
            if (mTxtVideo01.getText().toString().contentEquals(AppConfig.getIns().mVideoURLDefault) == false) {
                videos.add(IVideoIndex.VIDEO1);
            }
            if (mTxtVideo02.getText().toString().contentEquals(AppConfig.getIns().mVideoURLDefault) == false) {
                videos.add(IVideoIndex.VIDEO2);

            }
            if (mTxtVideo03.getText().toString().contentEquals(AppConfig.getIns().mVideoURLDefault) == false) {
                videos.add(IVideoIndex.VIDEO3);

            }
            if (mTxtVideo04.getText().toString().contentEquals(AppConfig.getIns().mVideoURLDefault) == false) {
                videos.add(IVideoIndex.VIDEO4);
            }
            mTxtVideo01.setText(AppConfig.getIns().mVideoURLDefault);
            mTxtVideo02.setText(AppConfig.getIns().mVideoURLDefault);
            mTxtVideo03.setText(AppConfig.getIns().mVideoURLDefault);
            mTxtVideo04.setText(AppConfig.getIns().mVideoURLDefault);
        } else {
            if (mTxtVideo01.getText().toString().contentEquals(AppConfig.getIns().mVideoURL01) == false) {
                videos.add(IVideoIndex.VIDEO1);
                AppConfig.getIns().mVideoURL01 = mTxtVideo01.getText().toString();
            }
            if (mTxtVideo02.getText().toString().contentEquals(AppConfig.getIns().mVideoURL02) == false) {
                videos.add(IVideoIndex.VIDEO2);
                AppConfig.getIns().mVideoURL02 = mTxtVideo02.getText().toString();
            }
            if ((mTxtVideo03.getText().toString().contentEquals(AppConfig.getIns().mVideoURL03)) == false) {
                videos.add(IVideoIndex.VIDEO3);
                AppConfig.getIns().mVideoURL03 = mTxtVideo03.getText().toString();
            }
            if (mTxtVideo04.getText().toString().contentEquals(AppConfig.getIns().mVideoURL04) == false) {
                videos.add(IVideoIndex.VIDEO4);
                AppConfig.getIns().mVideoURL04 = mTxtVideo04.getText().toString();
            }
        }

        if (mSettingCall != null) {
            mSettingCall.onSettingChanged(videos);
        }

    }

    public void showAlertDlg() {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("提示");
        String content = mBDefault ? "确定恢复原始默认地址?" : "确定保存新地址?";

        //设置正面按钮以及点击事件
        builder.setMessage(content);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checkSettingChange(mBDefault);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }
        );
        builder.show();

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
        Log.d(TAG, "setUserVisibleHint:" + isVisibleToUser);
        if (mBtnTest2 == null)
        {
            return;
        }
        if (isVisibleToUser == false)
        {
//            mBDefault = false;
//            showAlertDlg();
        }

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged:" + hidden);
    }


}
