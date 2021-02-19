package com.ai.jvideoassist;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class FragThird extends Fragment {

    private static final String TAG = "FragThird";

    public FragThird() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.txt_content,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_msg);
        txt_content.setText("第三个Fragment");
        Log.d(TAG,"onCreateView");
        return view;
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
        Log.d(TAG,"setUserVisibleHint:" + isVisibleToUser);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG,"onHiddenChanged:" + hidden);
    }
}
