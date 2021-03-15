package com.ai.jvideoassist.config;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * 应用程序全局配置实体类
 */
public class AppConfig {

    public String mServerIp;
    public String mServerPort;
    public String mVideoNum;
    public String mVideMaxNum;
    public String mPlayMode;

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
    }

    public void saveAppConifg(Context context) {

        PropertiesUtil.getIns().setValue("VideoShowNumber",mVideoNum);
        PropertiesUtil.getIns().setValue("VideoMaxNumber",mVideMaxNum);

        PropertiesUtil.getIns().setValue("ServerIP",mServerIp);
        PropertiesUtil.getIns().setValue("ServerPort",mServerPort);

        PropertiesUtil.getIns().setValue("PlayMode",mPlayMode);

        if (PropertiesUtil.getIns().saveProperties(context) == false) {
            Log.d(TAG, "error 保存appConfig配置文件失败");
        }
        else {
            Log.d(TAG, "OK 保存appConfig配置文件成功");
        }
    }


}
