package com.ai.jvideoassist.listener;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

/**
 * 单击,双击,触摸等事件接口定义
 */
public interface OnItemOptListener {

    void onItemTouch(View view, int position);

    void onItemDoubleClick(View view,int position);
}