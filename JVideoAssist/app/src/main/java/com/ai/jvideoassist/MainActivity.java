package com.ai.jvideoassist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import com.ai.jvideoassist.adapter.FragPagerAdapter;
import com.ai.jvideoassist.config.AppConfig;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {


    private final String TAG = AppConfig.TAG + this.getClass().getSimpleName();

    //UI Objects
    private TextView txt_topbar;

    private RadioGroup rg_tab_bar;
    private RadioButton rb_video;
    private RadioButton rb_voice;
    private RadioButton rb_setting;

    private ViewPager mVpager;

    private FragPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

//    public  Handler mHandler = new Handler(Looper.getMainLooper()){ // 解决
//
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate begin");

        //1. read config
        AppConfig.getIns().initAppConfig(getApplicationContext());

        mAdapter = new FragPagerAdapter(getSupportFragmentManager());
        bindViews();

        rb_video.setChecked(true);

        Log.d(TAG, "onCreate End");
    }


    @Override
    protected void onStart() {
        super.onStart();


        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        //save new setting
        AppConfig.getIns().saveAppConifg(getApplicationContext());

        Log.d(TAG, "onDestroy");

    }

    private void bindViews() {

        txt_topbar = findViewById(R.id.txt_main_topbar);
        rg_tab_bar = findViewById(R.id.rg_tab_bar);
        rb_video = findViewById(R.id.rb_video);
        rb_voice = findViewById(R.id.rb_voice);
        rb_setting = findViewById(R.id.rb_setting);
        rg_tab_bar.setOnCheckedChangeListener(this);

        mVpager = findViewById(R.id.vpager);
        mVpager.setAdapter(mAdapter);
        mVpager.setCurrentItem(0);
        mVpager.addOnPageChangeListener(this);
        mVpager.setOffscreenPageLimit(mAdapter.PAGER_COUNT);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.d(TAG, "checkedId: " + checkedId);
        switch (checkedId) {
            case R.id.rb_video:
                mVpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_voice:
                mVpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_setting:
                mVpager.setCurrentItem(PAGE_THREE);
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        Log.d(TAG, "position: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d(TAG, "state: " + state);

        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (mVpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_video.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_voice.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_setting.setChecked(true);
                    break;
            }
        }
    }


}