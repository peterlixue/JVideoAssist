package com.ai.jvideoassist;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class FragFourth extends Fragment {

    private static final String TAG = "FragFourth";

    public FragFourth() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.txt_content,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_msg);
        txt_content.setText("第四个Fragment");
        Log.d(TAG,"onCreateView");
        return view;
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


        Log.d(TAG, "FragFourth onDestroy");
    }
}
