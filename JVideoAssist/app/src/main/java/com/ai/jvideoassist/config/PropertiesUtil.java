package com.ai.jvideoassist.config;

import android.content.Context;
import android.telephony.mbms.FileInfo;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    private String dataSavePath;

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
            dataSavePath = String.format("%s/%s", context.getFilesDir().getAbsolutePath(), configPath);
            File cfgFile = new File(dataSavePath);
            if (cfgFile.exists()) {
                //data目录读取配置
                FileInputStream fileInputStream = new FileInputStream(dataSavePath);
                mCfgProps.load(fileInputStream);
                fileInputStream.close();
            }
            else {
                //从assert读取配置
                InputStream inputStream = context.getAssets().open(configPath);
                mCfgProps.load(inputStream);
                inputStream.close();
            }
            return true;
        }
        catch (IOException e) {
            Log.d(this.getClass().getSimpleName(),e.getMessage());
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
            File file = new File(dataSavePath);
            if (!file.exists())
            {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(dataSavePath);
            mCfgProps.store(fileOutputStream,null);
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            Log.d(this.getClass().getSimpleName(),e.getMessage());
            return false;
        }
    }
}
