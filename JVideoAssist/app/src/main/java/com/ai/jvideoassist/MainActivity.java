package com.ai.jvideoassist;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by Coder-pig on 2015/8/28 0028.
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {


    private static final String TAG = "MainActivity";
    //UI Objects
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;
    private RadioButton rb_message;
    private RadioButton rb_better;
    private RadioButton rb_setting;
    private ViewPager mVpager;

    private FragPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        //1. read config
        AppConfig.getIns().initAppConfig(getApplicationContext());

        mAdapter = new FragPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_channel.setChecked(true);
    }

    @Override
    protected void onStart() {
        super.onStart();


        Log.d(TAG, "onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //save new setting
        AppConfig.getIns().saveAppConifg(getApplicationContext());

        Log.d(TAG, "onDestroy");

    }

    private void bindViews() {
        txt_topbar = findViewById(R.id.txt_topbar);
        rg_tab_bar = findViewById(R.id.rg_tab_bar);
        rb_channel = findViewById(R.id.rb_channel);
        rb_message = findViewById(R.id.rb_message);
        rb_better = findViewById(R.id.rb_better);
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
        switch (checkedId) {
            case R.id.rb_channel:
                mVpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_message:
                mVpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_better:
                mVpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_setting:
                mVpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (mVpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_channel.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_message.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_better.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_setting.setChecked(true);
                    break;
            }
        }
    }




    public boolean isStoragePermissionGranted() {
        //6.0	23	Marshmallow(Android M)（棉花糖）
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.d("info", "Permission is granted");
                return true;
            } else {

                Log.d("info", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.d("info", "Permission is granted");
            return true;
        }


    }
}