package com.ai.jvideoassist.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Insets;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ai.jvideoassist.inter.IVideoIndex;
import com.ai.jvideoassist.inter.OnItemOptListener;
import com.ai.jvideoassist.R;
import com.ai.jvideoassist.util.SecondActivity;
import com.ai.jvideoassist.config.AppConfig;

import java.util.HashMap;

import cn.nodemedia.NodePlayer;
import cn.nodemedia.NodePlayerDelegate;
import cn.nodemedia.NodePlayerView;

public class NodePlayAdapter extends RecyclerView.Adapter<NodePlayAdapter.RecycleViewHolder> {

    private final String TAG = AppConfig.TAG + this.getClass().getSimpleName();

    private HashMap<Integer, String> mPlayUrlMap;

    private HashMap<Integer, RecycleViewHolder> mViewHolderMap;

    private Context mContext;


    //http://192.168.1.101:8080/?action=stream
    private String ip_addr = "192.168.1.101";
    private String port = "8080";

    //private String rtsp_addr = "rtmp://58.200.131.2:1935/livetv/cctv1";
    //private String rtsp_addr = "rtsp://192.168.1.101:8554/mytest";
    //private String rtsp_addr = "rtmp://192.168.1.101/live/livestream";
    private final int mFrameHeight = 100;

    private int mScreenWidth;
    private int mScreenHeight;

    private int mItemWidth;
    private int mItemHeight;

    private int mShowRow = 1;
    private int mShowCol = 1;
    private boolean isFullView;
    private NodePlayerView mPlayerView;
    private NodePlayer mPlayer;

    public NodePlayAdapter(HashMap<Integer, String> mapUrls, Context context) {
        this.mPlayUrlMap = mapUrls;
        this.mContext = context;

        mViewHolderMap = new HashMap<>();
    }

    private OnItemOptListener mItemDbClickListener;

    public void setOnItemOptListener(OnItemOptListener itemListener) {

        this.mItemDbClickListener = itemListener;
    }


    public void init(int showRow, int showCol) {

        mShowRow = showRow;
        mShowCol = showCol;
        //计算屏幕的宽高
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

            WindowMetrics windowMetrics = ((Activity) (mContext)).getWindowManager().getCurrentWindowMetrics();
            Insets insets = windowMetrics.getWindowInsets()
                    .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());

            mScreenHeight = windowMetrics.getBounds().height() - insets.top - insets.bottom;
            ;
            mScreenWidth = windowMetrics.getBounds().width() - insets.left - insets.right;


        } else {

            DisplayMetrics outMetrics = new DisplayMetrics();
            ((Activity) (mContext)).getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
            mScreenHeight = outMetrics.heightPixels;
            mScreenWidth = outMetrics.widthPixels;
        }

        Log.d(TAG, "mScreenHeight:" + mScreenHeight);
        Log.d(TAG, "mScreenWidth:" + mScreenWidth);


        Log.d(TAG, "mItemHeight:" + mItemHeight);
        Log.d(TAG, "mItemWidth:" + mItemWidth);


    }



    //RecycleView ItemView设置
    public class RecycleViewHolder extends RecyclerView.ViewHolder implements NodePlayerDelegate{

        private NodePlayerView nodePlayerView;
        private NodePlayer nodePlayer;
        private int reConCount = 0;
        private boolean firstTouch = false;
        private long lastClickTime = 0;
        private static final long DOUBLE_CLICK_TIME_DELTA = 500;//milliseconds


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
            //设置视频是否开启
            nodePlayer.setVideoEnable(true);
            nodePlayer.setAudioEnable(false);

            nodePlayer.setBufferTime(100);
            nodePlayer.setMaxBufferTime(0);
            nodePlayer.setAutoReconnectWaitTimeout(2000);

            //设置事件回调代理
            nodePlayer.setNodePlayerDelegate(this);
            //nodePlayerView.setVisibility(View.INVISIBLE);


        }

        @Override
        public void onEventCallback(NodePlayer player, int event, String msg) {

            Log.d(TAG, player.toString() + event + ": "+ msg);
            if (event == 1003)
            {
                reConCount += 1;
                if (reConCount > 3 && player != null) {
                    player.stop();
                }
            }
        }



    }

    @NonNull
    @Override
    public NodePlayAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_nodeview, parent, false);
        Log.d(TAG, "onCreateViewHolder begin");
//        view.getLayoutParams().width = mItemWidth;
//        view.getLayoutParams().height = mItemHeight;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = parent.getMeasuredHeight() / mShowRow;
        layoutParams.width = parent.getMeasuredWidth() / mShowCol;
        view.setLayoutParams(layoutParams);

        return new RecycleViewHolder(view);
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final NodePlayAdapter.RecycleViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder begin");
        holder.nodePlayer.setInputUrl(mPlayUrlMap.get(position));

        if (!mViewHolderMap.containsKey(position)) {
            mViewHolderMap.put(position, holder);
        }

        holder.nodePlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Log.d(TAG, "onClick begin");
                if (!holder.firstTouch) {
                    holder.firstTouch = true;
                    holder.lastClickTime = System.currentTimeMillis();
                } else {
                    long nowClickTime = System.currentTimeMillis();
                    long timeDiff = nowClickTime - holder.lastClickTime;
                    if (timeDiff < RecycleViewHolder.DOUBLE_CLICK_TIME_DELTA) {
                        //double click event
                        if (mItemDbClickListener != null) {
                            mItemDbClickListener.onItemDoubleClick(v, position);
                        }
                    }
                    holder.firstTouch = false;

                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return mPlayUrlMap.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecycleViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        Log.d(TAG,"RecycleViewHolder:" + holder + "添加到视图");
        if (mViewHolderMap.size() >= mPlayUrlMap.size()) {
            if (mItemDbClickListener != null) {
                mItemDbClickListener.onStartPlay();
            }
        }
    }

    public static String getURLFromPosition(int videoIndex) {

        String tempUrl = "";
        switch (videoIndex) {
            case IVideoIndex.VIDEO1:
                tempUrl = AppConfig.getIns().mVideoURL01;
                break;
            case IVideoIndex.VIDEO2:
                tempUrl = AppConfig.getIns().mVideoURL02;
                break;
            case IVideoIndex.VIDEO3:
                tempUrl = AppConfig.getIns().mVideoURL03;
                break;
            case IVideoIndex.VIDEO4:
                tempUrl = AppConfig.getIns().mVideoURL04;
                break;
        }
        return tempUrl;
    }
    public void updatePlayUrl(int videoIndex) {
        if (mViewHolderMap.containsKey(videoIndex) == false) {
            Log.d(TAG, "error: 相机videoIndex: " + videoIndex + "没有找到对应播放控件");
            return;
        }

        String tempUrl = getURLFromPosition(videoIndex);

        if (mPlayUrlMap.get(videoIndex).contentEquals(tempUrl) == true) //播放地址没变
        {
            Log.d(TAG, "相机" + videoIndex + "地址没变");
            return;
        }
        //变化地址
        mViewHolderMap.get(videoIndex).nodePlayer.stop();
        mPlayUrlMap.put(videoIndex, tempUrl);
        mViewHolderMap.get(videoIndex).nodePlayer.setInputUrl(tempUrl);
        Log.d(TAG, "相机videoIndex: " + videoIndex + "更新到新的播放地址: " + tempUrl);
    }


    public void updatePlayUrl(int videoIndex,String tempUrl) {
        if (mViewHolderMap.containsKey(videoIndex) == false) {
            Log.d(TAG, "error: 相机videoIndex: " + videoIndex + "没有找到对应播放控件");
            return;
        }

        if (mPlayUrlMap.get(videoIndex).contentEquals(tempUrl) == true) //播放地址没变
        {
            Log.d(TAG, "相机" + videoIndex + "地址没变");
            return;
        }
        //变化地址
        mViewHolderMap.get(videoIndex).nodePlayer.stop();
        mPlayUrlMap.put(videoIndex, tempUrl);
        mViewHolderMap.get(videoIndex).nodePlayer.setInputUrl(tempUrl);
        Log.d(TAG, "相机videoIndex: " + videoIndex + "更新到新的播放地址: " + tempUrl);
    }


    public void startPlayerAll() {
        for (Integer key : mViewHolderMap.keySet()) {

            mViewHolderMap.get(key).nodePlayer.start();

        }
    }


    public void startAnotherAct() {
        try {
            //startActivity(new Intent("com.AndroidTest.SecondActivity"));//隐式intent
            Intent intent = new Intent(mContext, SecondActivity.class);//显示intent
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        } catch (Exception ex) {
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

    public int bindDataCount()
    {
        return mViewHolderMap.size();
    }

    public void puaseALl() {
        for (Integer key : mViewHolderMap.keySet()) {

            mViewHolderMap.get(key).nodePlayer.pause();

        }
    }

    public void stopALl() {
        for (Integer key : mViewHolderMap.keySet()) {
            if (mViewHolderMap.get(key).nodePlayer.isPlaying()) {
                mViewHolderMap.get(key).nodePlayer.stop();
            }
        }
    }

    public void realeaseAll() {
        for (Integer key : mViewHolderMap.keySet()) {

            mViewHolderMap.get(key).nodePlayer.release();

        }
    }

}