package com.ai.jvideoassist;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WebViewAdapter extends RecyclerView.Adapter<WebViewAdapter.RecycleViewHolder> {

    private List<String> list;
    Context context;

    private List<WebView> mWebViews;

    //http://192.168.1.101:8080/?action=stream
    private String ip_addr = "192.168.1.101";
    private String port = "8080";


    public WebViewAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;

        mWebViews = new ArrayList<>();
    }

    //RecycleView ItemView设置
    public class RecycleViewHolder extends RecyclerView.ViewHolder {

        WebView mView;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView.findViewById(R.id.video_webview);


            WebSettings WebSet = mView.getSettings();    //获取webview设置
            WebSet.setJavaScriptEnabled(true);              //设置JavaScript支持

            WebSet.setSupportZoom(true);            // 设置可以支持缩放

            WebSet.setBuiltInZoomControls(true);    // 设置出现缩放工具

            WebSet.setUseWideViewPort(true);        //扩大比例的缩放

            WebSet.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);   //自适应屏幕
            WebSet.setLoadWithOverviewMode(true);

            mView.loadUrl("http://"+ip_addr+":"+port+"/?action=stream");

            mView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    Log.d("WebViewAdapter","开始加载");
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    Log.d("WebViewAdapter","加载结束");
                }

                // 链接跳转都会走这个方法
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    Log.d("WebViewAdapter","Url："+ url );
                    view.loadUrl(url);// 强制在当前 WebView 中加载 url
                    return true;
                }
            });
        }
    }

    @NonNull
    @Override
    public WebViewAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_webview, parent, false);
        RecycleViewHolder myViewHolder = new RecycleViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WebViewAdapter.RecycleViewHolder holder, int position) {
        WebView view = holder.mView;
        //view.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}