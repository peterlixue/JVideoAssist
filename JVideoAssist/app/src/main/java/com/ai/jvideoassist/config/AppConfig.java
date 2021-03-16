package com.ai.jvideoassist.config;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Properties;

/**
 * 应用程序全局配置实体类
 */
public class AppConfig {

    public String mServerIp;
    public String mServerPort;
    public String mVideoNum;
    public String mVideMaxNum;
    public String mPlayMode;

    public String   mVideoURLDefault;
    public String   mVideoURL01;
    public String   mVideoURL02;
    public String   mVideoURL03;
    public String   mVideoURL04;

    public static final String TAG = "MyLog ";

    private AppConfig() {}

    private static class SingletonAppConfigHolder {
        private static final AppConfig mInstance = new AppConfig();
    }
    public static AppConfig getIns() {
        return SingletonAppConfigHolder.mInstance;
    }

    @NonNull
    public String getTag(Object logObject) {
        return "MyLog " + logObject.getClass().getSimpleName();
    }

    public void initAppConfig(Context context) {

        if (PropertiesUtil.getIns().loadProperties(context) == false) {
            Log.d(TAG, "error 读取appConfig配置文件失败");
        }
        else {
            Log.d(TAG, "OK 读取appConfig配置文件成功");
        }
        mVideoNum = PropertiesUtil.getIns().getValue("VideoShowNumber", "4");
        mVideMaxNum = PropertiesUtil.getIns().getValue("VideoMaxNumber", "16");

        mServerIp = PropertiesUtil.getIns().getValue("ServerIP","127.0.0.1");
        mServerPort = PropertiesUtil.getIns().getValue("ServerPort","5000");

        mPlayMode = PropertiesUtil.getIns().getValue("PlayMode","1");

        mVideoURLDefault = PropertiesUtil.getIns().getValue("VideoURLDefault","rtmp://58.200.131.2:1935/livetv/cctv1");

        mVideoURL01 = PropertiesUtil.getIns().getValue("VideoURL01","rtmp://58.200.131.2:1935/livetv/cctv1");
        mVideoURL02 = PropertiesUtil.getIns().getValue("VideoURL02","rtmp://58.200.131.2:1935/livetv/cctv1");
        mVideoURL03 = PropertiesUtil.getIns().getValue("VideoURL03","rtmp://58.200.131.2:1935/livetv/cctv1");
        mVideoURL04 = PropertiesUtil.getIns().getValue("VideoURL04","rtmp://58.200.131.2:1935/livetv/cctv1");
    }

    public void saveAppConifg(Context context) {

        PropertiesUtil.getIns().setValue("VideoShowNumber",mVideoNum);
        PropertiesUtil.getIns().setValue("VideoMaxNumber",mVideMaxNum);

        PropertiesUtil.getIns().setValue("ServerIP",mServerIp);
        PropertiesUtil.getIns().setValue("ServerPort",mServerPort);

        PropertiesUtil.getIns().setValue("PlayMode",mPlayMode);

        PropertiesUtil.getIns().setValue("VideoURLDefault",mVideoURLDefault);
        PropertiesUtil.getIns().setValue("VideoURL01",mVideoURL01);
        PropertiesUtil.getIns().setValue("VideoURL02",mVideoURL02);
        PropertiesUtil.getIns().setValue("VideoURL03",mVideoURL03);
        PropertiesUtil.getIns().setValue("VideoURL04",mVideoURL04);


        if (PropertiesUtil.getIns().saveProperties(context) == false) {
            Log.d(TAG, "error 保存appConfig配置文件失败");
        }
        else {
            Log.d(TAG, "OK 保存appConfig配置文件成功");
        }
    }


}
