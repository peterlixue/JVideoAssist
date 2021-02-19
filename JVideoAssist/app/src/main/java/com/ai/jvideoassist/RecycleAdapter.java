package com.ai.jvideoassist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder> {

    private List<String> list;
    Context context;



    public RecycleAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //RecycleView ItemView设置
    public class RecycleViewHolder extends RecyclerView.ViewHolder {

        SurfaceView mSurfaceView;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            mSurfaceView = itemView.findViewById(R.id.video_surfview);
        }
    }

    @NonNull
    @Override
    public RecycleAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle_video, parent, false);
        RecycleViewHolder myViewHolder = new RecycleViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.RecycleViewHolder holder, int position) {
        SurfaceView surfaceView = holder.mSurfaceView;
        //surfaceView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}