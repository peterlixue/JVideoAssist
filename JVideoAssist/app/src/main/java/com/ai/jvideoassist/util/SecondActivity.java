package com.ai.jvideoassist.util;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ai.jvideoassist.MainActivity;
import com.ai.jvideoassist.R;
import com.ai.jvideoassist.config.AppConfig;

import cn.nodemedia.NodePlayer;
import cn.nodemedia.NodePlayerView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = AppConfig.TAG + this.getClass().getSimpleName();

    private NodePlayerView mPlayView;
    private NodePlayer  mPlayer;
    private boolean isFullView;


    private final String rtsp_addr = "rtmp://58.200.131.2:1935/livetv/cctv1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent intent = this.getIntent();    //获得当前的Intent
        Bundle bundle = intent.getExtras();  //获得全部数据
        if (bundle != null) {
            String value = bundle.getString("name");  //获得名为name的值
        }



        mPlayView = findViewById(R.id.video_fullNode);
        //设置渲染器类型
        mPlayView.setRenderType(NodePlayerView.RenderType.SURFACEVIEW);
        //设置视频画面缩放模式
        mPlayView.setUIViewContentMode(NodePlayerView.UIViewContentMode.ScaleToFill);

        mPlayer = new NodePlayer(this);
        //设置播放视图
        mPlayer.setPlayerView(mPlayView);
        //设置RTSP流使用的传输协议,支持的模式有:
        mPlayer.setRtspTransport(NodePlayer.RTSP_TRANSPORT_TCP);
        mPlayer.setInputUrl(rtsp_addr);
        //设置视频是否开启
        mPlayer.setVideoEnable(true);
        mPlayer.setBufferTime(0);
        mPlayer.setMaxBufferTime(0);
        //mPlayer.start();
        mPlayView.setClickable(true);

        mPlayView.setOnClickListener(this);

        Log.d(TAG,"onCreate over");
    }

    @Override
    public void onClick(View v) {
        try
        {
            //startActivity(new Intent("com.AndroidTest.SecondActivity"));//隐式intent
            Intent intent = new Intent(this, MainActivity.class);//显示intent
            startActivity(intent);
        }
        catch (Exception ex)
        {
            // 显示异常信息
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPlayer.start();

        Log.d(TAG,"onStart over");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPlayer.stop();

        Log.d(TAG,"onStop over");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG,"onResume over");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        Log.d(TAG,"onDestroy over");
    }

    @Override
    protected void onRestart() {
        super.onRestart();


        Log.d(TAG,"onRestart over");
    }

}
