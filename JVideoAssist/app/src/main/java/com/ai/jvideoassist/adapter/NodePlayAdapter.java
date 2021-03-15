package com.ai.jvideoassist.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Insets;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ai.jvideoassist.listener.OnItemOptListener;
import com.ai.jvideoassist.R;
import com.ai.jvideoassist.util.SecondActivity;
import com.ai.jvideoassist.config.AppConfig;

import java.util.HashMap;

import cn.nodemedia.NodePlayer;
import cn.nodemedia.NodePlayerView;

public class NodePlayAdapter extends RecyclerView.Adapter<NodePlayAdapter.RecycleViewHolder> {

    private final String TAG = AppConfig.TAG + this.getClass().getSimpleName();

    private HashMap<Integer,String> mPlayUrlMap;

    private HashMap<Integer,RecycleViewHolder> mViewHolderMap;

    private Context mContext;


    //http://192.168.1.101:8080/?action=stream
    private String ip_addr = "192.168.1.101";
    private String port = "8080";

    //private String rtsp_addr = "rtmp://58.200.131.2:1935/livetv/cctv1";
    //private String rtsp_addr = "rtsp://192.168.1.101:8554/mytest";
    private String rtsp_addr = "rtmp://192.168.1.101/live/livestream";
    private final  int mFrameHeight = 0;

    private int mScreenWidth;
    private int mScreenHeight;

    private int mItemWidth;
    private int mItemHeight;

    private boolean isFullView;
    private NodePlayerView mPlayerView;
    private NodePlayer mPlayer;

    public NodePlayAdapter(HashMap<Integer,String> mapUrls, Context context) {
        this.mPlayUrlMap = mapUrls;
        this.mContext = context;

        mViewHolderMap = new HashMap<>();
    }

    private OnItemOptListener mItemDbClickListener;

    public void setOnItemOptListener(OnItemOptListener itemListener) {

        this.mItemDbClickListener = itemListener;
    }


    public void init(int showRow, int showCol) {


        //计算屏幕的宽高
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

            WindowMetrics windowMetrics = ((Activity) (mContext)).getWindowManager().getCurrentWindowMetrics();
            Insets insets = windowMetrics.getWindowInsets()
                    .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());

            mScreenHeight = windowMetrics.getBounds().height() - insets.top - insets.bottom ;
            ;
            mScreenWidth = windowMetrics.getBounds().width() - insets.left - insets.right;

            mItemHeight = (mScreenHeight - mFrameHeight)/ showRow;
            mItemWidth = mScreenWidth / showCol;
        } else {

            DisplayMetrics outMetrics = new DisplayMetrics();
            ((Activity) (mContext)).getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
            mScreenHeight = outMetrics.heightPixels ;
            mScreenWidth = outMetrics.widthPixels;
            mItemHeight = (mScreenHeight - mFrameHeight) / showRow;
            mItemWidth = mScreenWidth / showCol;
        }

        Log.d(TAG, "mScreenHeight:" + mScreenHeight);
        Log.d(TAG, "mScreenWidth:" + mScreenWidth);
        Log.d(TAG, "mItemHeight:" + mItemHeight);
        Log.d(TAG, "mItemWidth:" + mItemWidth);


    }


    //RecycleView ItemView设置
    public class RecycleViewHolder extends RecyclerView.ViewHolder {

        private NodePlayerView nodePlayerView;
        private NodePlayer nodePlayer;
        private boolean firstTouch = false;
        private long  lastClickTime = 0;
        private static final long DOUBLE_CLICK_TIME_DELTA = 300;//milliseconds


        @SuppressLint("ClickableViewAccessibility")
        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);


            isFullView = false;

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
            nodePlayer.setInputUrl(rtsp_addr);
            //设置视频是否开启
            nodePlayer.setVideoEnable(true);
            nodePlayer.setBufferTime(10);
            nodePlayer.setMaxBufferTime(0);

            //nodePlayerView.setVisibility(View.INVISIBLE);


        }


    }

    @NonNull
    @Override
    public NodePlayAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_nodeview, parent, false);
        Log.d(TAG,"onCreateViewHolder begin");
        view.getLayoutParams().width = mItemWidth;
        view.getLayoutParams().height = mItemHeight;
        return new RecycleViewHolder(view);
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final NodePlayAdapter.RecycleViewHolder holder, final int position) {

        Log.d(TAG,"onBindViewHolder begin");


        if (!mViewHolderMap.containsKey(position))
        {
            mViewHolderMap.put(position,holder);
        }

        holder.nodePlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!holder.firstTouch) {
                    holder.firstTouch = true;
                    holder.lastClickTime = System.currentTimeMillis();
                }
                else {
                    long nowClickTime = System.currentTimeMillis();
                    if (nowClickTime - holder.lastClickTime < RecycleViewHolder.DOUBLE_CLICK_TIME_DELTA) {
                        //double click event
                        holder.firstTouch = false;
                        Toast.makeText(mContext,"双击了View"+position,Toast.LENGTH_SHORT).show();
                        if (mItemDbClickListener != null) {
                            mItemDbClickListener.onItemDoubleClick(v,position);


                    }
                }

                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return mPlayUrlMap.size();
    }


    public void startPlayerAll() {
        for(Integer key : mViewHolderMap.keySet()){

            mViewHolderMap.get(key).nodePlayer.start();

        }
    }

    public void startAnotherAct() {
        try
        {
            //startActivity(new Intent("com.AndroidTest.SecondActivity"));//隐式intent
            Intent intent = new Intent(mContext, SecondActivity.class);//显示intent
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
        catch (Exception ex)
        {
            // 显示异常信息
            Toast.makeText(mContext, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setFullView(View v) {
        if (!isFullView) {

            v.getLayoutParams().width = mScreenWidth;
            v.getLayoutParams().height = mScreenHeight;
            isFullView = true;
            Log.d("nodePlayerView", "enter fullscreen view");
        } else {

            v.getLayoutParams().width = mItemWidth;
            v.getLayoutParams().height = mItemHeight;
            isFullView = false;
            Log.d("nodePlayerView", "enter normal view");
        }
    }

    public void enterFullMode(View v,int position) {

        for(Integer key : mViewHolderMap.keySet()){
            if (key != position) {
                //mViewHolderMap.get(key).nodePlayerView.setVisibility(View.INVISIBLE);
            }

        }
    }

    public void exitFullMode(View v,int position) {

        for(Integer key : mViewHolderMap.keySet()){

            //mViewHolderMap.get(key).nodePlayerView.setVisibility(View.VISIBLE);
        }

    }

    public void puaseALl()
    {
        for(Integer key : mViewHolderMap.keySet()){

            mViewHolderMap.get(key).nodePlayer.pause();

        }
    }

    public void stopALl()
    {
        for(Integer key : mViewHolderMap.keySet()){

            mViewHolderMap.get(key).nodePlayer.stop();

        }
    }

    public void realeaseAll()
    {
        for(Integer key : mViewHolderMap.keySet()){

            mViewHolderMap.get(key).nodePlayer.release();

        }
    }

}