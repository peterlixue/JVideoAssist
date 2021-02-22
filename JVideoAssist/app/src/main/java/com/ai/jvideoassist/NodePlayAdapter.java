package com.ai.jvideoassist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.nfc.Tag;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.nodemedia.NodePlayer;
import cn.nodemedia.NodePlayerView;

public class NodePlayAdapter extends RecyclerView.Adapter<NodePlayAdapter.RecycleViewHolder> {

    private List<String> list;
    Context mContext;


    //http://192.168.1.101:8080/?action=stream
    private String ip_addr = "192.168.1.101";
    private String port = "8080";

    private int mScreenWidth;
    private int mScreenHeight;

    private int mItemWidth;
    private int mItemHeight;


    public NodePlayAdapter(List<String> list, Context context) {
        this.list = list;
        this.mContext = context;

    }

    public void init(int showRow, int showCol) {


        //计算屏幕的宽高
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

            WindowMetrics windowMetrics = ((Activity) (mContext)).getWindowManager().getCurrentWindowMetrics();
            Insets insets = windowMetrics.getWindowInsets()
                    .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());

            mScreenHeight = windowMetrics.getBounds().height() - insets.top - insets.bottom;;
            mScreenWidth = windowMetrics.getBounds().width() - insets.left - insets.right;

            mItemHeight = mScreenHeight / showRow;
            mItemWidth = mScreenWidth / showCol;
        } else {

            DisplayMetrics outMetrics = new DisplayMetrics();
            ((Activity) (mContext)).getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
            mScreenHeight = outMetrics.heightPixels;
            mScreenWidth = outMetrics.widthPixels;
            mItemHeight = mScreenHeight / showRow;
            mItemWidth = mScreenWidth / showCol;
        }

        Log.d("NodePlayAdapter","mScreenHeight:" + mScreenHeight);
        Log.d("NodePlayAdapter","mScreenWidth:" + mScreenWidth);
        Log.d("NodePlayAdapter","mItemHeight:" + mItemHeight);
        Log.d("NodePlayAdapter","mItemWidth:" + mItemWidth);



    }


    //RecycleView ItemView设置
    public class RecycleViewHolder extends RecyclerView.ViewHolder {

        private NodePlayerView nodePlayerView;
        private NodePlayer nodePlayer;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);


            nodePlayerView = itemView.findViewById(R.id.video_nodeplayer);
            //设置渲染器类型
            nodePlayerView.setRenderType(NodePlayerView.RenderType.SURFACEVIEW);
            //设置视频画面缩放模式
            nodePlayerView.setUIViewContentMode(NodePlayerView.UIViewContentMode.ScaleToFill);

            nodePlayer = new NodePlayer(mContext);
            //设置播放视图
            nodePlayer.setPlayerView(nodePlayerView);
            //设置RTSP流使用的传输协议,支持的模式有:
            nodePlayer.setRtspTransport(NodePlayer.RTSP_TRANSPORT_TCP);
            nodePlayer.setInputUrl("rtmp://58.200.131.2:1935/livetv/cctv1");
            //设置视频是否开启
            nodePlayer.setVideoEnable(true);
            nodePlayer.setBufferTime(10);
            nodePlayer.setMaxBufferTime(0);
            //nodePlayer.start();


        }


    }

    @NonNull
    @Override
    public NodePlayAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_nodeview, parent, false);
        view.getLayoutParams().width = mItemWidth;
        view.getLayoutParams().height = mItemHeight;

        RecycleViewHolder myViewHolder = new RecycleViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NodePlayAdapter.RecycleViewHolder holder, int position) {
        NodePlayer myplayer = holder.nodePlayer;
        myplayer.start();
        //view.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}