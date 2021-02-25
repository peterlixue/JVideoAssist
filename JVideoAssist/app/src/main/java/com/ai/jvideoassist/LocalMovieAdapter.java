package com.ai.jvideoassist;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class LocalMovieAdapter extends RecyclerView.Adapter<LocalMovieAdapter.LocalViewHolder> {

    private final String TAG = AppConfig.TAG + this.getClass().getSimpleName();

    private Context context;
    private List<LocalMovieBean> mDatas;
    private MediaPlayer player;

    private int currentPostion = -1;

    public LocalMovieAdapter(Context context,List<LocalMovieBean> datas) {
        this.context = context;
        this.mDatas = datas;
        player = new MediaPlayer();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d("LocalMovieAdapter", "Play onCompletion");
            }
        });
    }

    public void destroyPlayer() {
        if (player != null) {
            player.stop();
            player.release();
        }
    }

    @NonNull
    @Override
    public LocalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_local_movie,parent,false);
        LocalViewHolder holder = new LocalViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LocalViewHolder holder, int position) {

        final LocalMovieBean bean = mDatas.get(position);
        holder.mTitleTv.setText(bean.getName());

        SimpleDateFormat sDateFormat = new SimpleDateFormat("mm:ss");
        String time = sDateFormat.format(new Date(bean.getDuration()));
        holder.mDurationTv.setText("播放时长： " + time);
        long tSize = bean.getSize() / 1024 / 1024;
        holder.mSizeTv.setText("视频大小： " + tSize);

        Bitmap thumbnail = ThumbnailUtils.createVideoThumbnail(bean.getPath(), MediaStore.Video.Thumbnails.MINI_KIND);
        holder.mThumbIv.setImageBitmap(thumbnail);

        holder.mThumbIv.setTag(position);

        holder.mThumbIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer) v.getTag();
                Log.d("LocalMovieAdapter","position:" + pos);
                currentPostion = pos;
                notifyDataSetChanged();
            }
        });

        if (currentPostion == position) {

            Log.d("LocalMovieAdapter","currentPostion:" + position);
            try {

                if(player.isPlaying()){
                    player.stop();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            holder.mSurfaceView.setVisibility(View.VISIBLE);
            holder.mThumbIv.setVisibility(View.INVISIBLE);
            SurfaceHolder surfaceHolder = holder.mSurfaceView.getHolder();
            surfaceHolder.addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(@NonNull SurfaceHolder holder) {
                    player.reset();
                    player.setDisplay(holder);
                    try
                    {
                        player.setDataSource(bean.getPath());
                        player.prepare();
                        player.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

                }

                @Override
                public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

                }
            });
        }
        else {
            holder.mSurfaceView.setVisibility(View.INVISIBLE);
            holder.mThumbIv.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class LocalViewHolder extends RecyclerView.ViewHolder {

        SurfaceView mSurfaceView;
        ImageView mThumbIv;
        TextView mTitleTv,mDurationTv,mSizeTv;

        public LocalViewHolder(View view) {
            super(view);

            mSurfaceView = itemView.findViewById(R.id.surfaceView);
            mThumbIv = view.findViewById(R.id.item_iv);
            mTitleTv = (TextView)view.findViewById(R.id.item_titile);
            mDurationTv = view.findViewById(R.id.item_time);
            mSizeTv = view.findViewById(R.id.item_size);
        }
    }





}
