package com.ai.jvideoassist;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Android Studio 配置读写工具单例类
 */
public class PropertiesUtil {

    private static String configPath = "appConfig.properties";
    private Properties mCfgProps;

    //ready to use singleton pattern
    private PropertiesUtil(){}

    private static class SingletonHolder {
        private static final PropertiesUtil mInstance = new PropertiesUtil();
    }
    public static PropertiesUtil getIns()
    {
        return SingletonHolder.mInstance;
    }

    public boolean loadProperties(Context context) {
        mCfgProps = new Properties();
        try {
            InputStream inputStream = context.getAssets().open(configPath);
            mCfgProps.load(inputStream);
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public String getValue(String key,String defaultValue) {
        return mCfgProps.getProperty(key,defaultValue);
    }

    public void setValue(String key,String value) {
        mCfgProps.setProperty(key,value);
    }

    public boolean saveProperties(Context context) {
        try
        {
            FileOutputStream outputStream = context.openFileOutput(configPath,Context.MODE_PRIVATE);
            mCfgProps.store(outputStream,null);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
