package com.ai.jvideoassist.util;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * no use for girdlayout manager
 */
class MyDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;
    public MyDecoration(Context context)
    {
        mContext = context;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state)
    {
        super.getItemOffsets(outRect, view, parent, state);
        //mContext.getResources().getDimensionPixelOffset(R.dimen.dividerHeight
        outRect.set(10, 10, 10, 12 );
    }
}
