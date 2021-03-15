package com.ai.jvideoassist.widget;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.ai.jvideoassist.util.JsonParser;
import com.ai.jvideoassist.R;
import com.ai.jvideoassist.config.AppConfig;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 语音识别界面
 */
public class FragVoice extends Fragment {

    private final String TAG = AppConfig.TAG + this.getClass().getSimpleName();

    private Context mContext;
    private Toast mToast;

    private TextView  mResultView;
    private TextView  mMsgView;
    private Button    mStartBtn;
    private Button    mStopBtn;

    // 用HashMap存储听写结果
    private HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();

    private RecognizerDialog mRecDlg;

    private final  String  mAppID = "=6046ca59";
    private String resultType = "json";

    public FragVoice() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_voice,container,false);
        mContext = view.getContext();
        mToast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
        mResultView = (TextView) view.findViewById(R.id.txt_result);
        mMsgView = view.findViewById(R.id.txt_msg);
        mStartBtn = view.findViewById(R.id.buttonStart);
        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRecDlg != null)
                {
                    mRecDlg.show();
                }
            }
        });
        mStopBtn = view.findViewById(R.id.buttonStop);
        mStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRecDlg != null && mRecDlg.isShowing())
                {
                    mRecDlg.hide();
                }
            }
        });
        Log.d(TAG,"onCreateView begin");
        //权限检测
        initPermission();

        // 将“12345678”替换成您申请的 APPID
        SpeechUtility.createUtility(mContext, SpeechConstant.APPID + mAppID);

        //1.创建SpeechRecognizer对象，第二个参数：本地听写时传InitListener
        mRecDlg = new RecognizerDialog(mContext,mInitListener);

        //2.设置听写参数，详见《科大讯飞MSC API手册(Android)》SpeechConstant类
        //iat：日常用语        //medical：医疗
        //mRecDlg.setParameter(SpeechConstant.DOMAIN, "iat");
        mRecDlg.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mRecDlg.setParameter(SpeechConstant.ACCENT, "mandarin ");
        // 设置语音前端点:静音超时时间，即用户多长时间不说话则当做超时处理
        mRecDlg.setParameter(SpeechConstant.VAD_BOS,"4000");

        // 设置语音后端点:后端点静音检测时间，即用户停止说话多长时间内即认为不再输入， 自动停止录音
        mRecDlg.setParameter(SpeechConstant.VAD_EOS, "1000");

        //设置标点符号,设置为"0"返回结果无标点,设置为"1"返回结果有标点
        mRecDlg.setParameter(SpeechConstant.ASR_PTT,"0");
        // 设置返回结果格式
        mRecDlg.setParameter(SpeechConstant.RESULT_TYPE, resultType);

        mRecDlg.setListener(mRecoDlgListener);

        Log.d(TAG,"onCreateView");
        return view;
    }

    /**
     * 初始化监听器。
     */
    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            Log.d(TAG, "SpeechRecognizer init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                showTip("初始化失败，错误码：" + code+",请点击网址https://www.xfyun.cn/document/error-code查询解决方案");
            }
        }
    };

    private RecognizerDialogListener mRecoDlgListener = new RecognizerDialogListener() {
        @Override
        public void onResult(RecognizerResult results, boolean isLast) {
            Log.d(TAG, results.getResultString());
            if (resultType.equals("json")) {

                printResult(results);

            }else if(resultType.equals("plain")) {
//                buffer.append(results.getResultString());
//                mResultText.setText(buffer.toString());
//                mResultText.setSelection(mResultText.length());
                mResultView.setText(results.getResultString());
            }

        }

        @Override
        public void onError(SpeechError speechError) {
            mMsgView.setText(speechError.getErrorDescription());
        }


    };

    private void showTip(final String str) {
        mToast.setText(str);
        mToast.show();
    }

    private void printResult(RecognizerResult results) {
        String text = JsonParser.parseIatResult(results.getResultString());

        String sn = null;
        // 读取json结果中的sn字段
        try {
            JSONObject resultJson = new JSONObject(results.getResultString());
            sn = resultJson.optString("sn");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mIatResults.put(sn, text);

        StringBuffer resultBuffer = new StringBuffer();
        for (String key : mIatResults.keySet()) {
            resultBuffer.append(mIatResults.get(key));
        }
        mResultView.setText(resultBuffer.toString());

    }


    /**
     * android 6.0 以上需要动态申请权限
     */
    private void initPermission() {
        String permissions[] = {Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.INTERNET
        };

        ArrayList<String> toApplyList = new ArrayList<String>();

        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission((Activity) mContext, perm)) {
                toApplyList.add(perm);
            }
        }
        if (toApplyList.size() > 0) {
            String tmpList[] = new String[toApplyList.size()];
            if (!toApplyList.isEmpty()) {
                ActivityCompat.requestPermissions((Activity) mContext, toApplyList.toArray(tmpList), 123);
            }
        } else {

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 此处为android 6.0以上动态授权的回调，用户自行实现。
        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission((Activity) mContext, perm)) {
                showTip("权限未开通:" + perm);
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "FragFourth onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "FragFourth onStop");
        //停止显示
        //mRecycleAdapter.getItemCount()
    }

    @Override
    public void onResume() {

        super.onResume();
        Log.d(TAG, "FragFourth onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mRecDlg != null)
        {
            mRecDlg.destroy();
        }

        Log.d(TAG, "FragFourth onDestroy");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG,"setUserVisibleHint:" + isVisibleToUser);
        if (isVisibleToUser)
        {
            if (mRecDlg != null && mRecDlg.isShowing() == false)
            {
                mRecDlg.show();
                showTip("请开始说话...");
            }
        }

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG,"onHiddenChanged:" + hidden);
    }


}
