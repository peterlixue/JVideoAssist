package com.ai.jvideoassist.widget;


import android.view.ViewGroup;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

/**
 *
 * @className: CellLayout
 * @description: 给ViewPager每一页使用的GridLayout, 均分屏幕 默认是3行3列 可以设置行距,
 *               不能在ScrollView中使用
 * @author: gaoshuai
 * @date: 2015年9月25日 上午10:46:55
 */
public class CellLayout extends ViewGroup
{
    private int lineNum = 3;
    private int columnNum = 3;
    private int vecitcalSpace;
    private int horizontalSpace;
    private int mCellWidth;
    private int mCellHeight;

    public CellLayout(Context context) {
        super(context);
    }

    public CellLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CellLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        final long drawingTime = getDrawingTime();
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            drawChild(canvas, getChildAt(i), drawingTime);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode != MeasureSpec.EXACTLY) {
            throw new IllegalStateException("CellLayout can only be used in EXACTLY mode.");
        }
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode != MeasureSpec.EXACTLY) {
            throw new IllegalStateException("CellLayout can only be used in EXACTLY mode.");
        }
        //        int layoutWidth = this.getWidth();
        //        int layoutHeight = this.getHeight();
        int layoutHeight = MeasureSpec.getSize(heightMeasureSpec);
        int layoutWidth = MeasureSpec.getSize(widthMeasureSpec);
        mCellWidth = 0;
        mCellHeight = 0;
        if (this.columnNum > 0) {
            //cellWidth = layoutWidth/this.columnNum - (this.columnNum + 1) * this.horizontalSpace;
            mCellWidth = (layoutWidth - (this.columnNum + 1) * this.horizontalSpace) / this.columnNum;
        }
        if (this.lineNum > 0) {
            mCellHeight = (layoutHeight - (this.lineNum + 1) * this.vecitcalSpace) / this.lineNum;

        }

        // The children are given the same width and height as the workspace
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            //getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec);
            getChildAt(i).measure(MeasureSpec.makeMeasureSpec(mCellWidth, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(mCellHeight, MeasureSpec.EXACTLY));
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        int index = 0;
        for (int i = 0; i < this.lineNum; i++) {
            for (int j = 0; j < this.columnNum; j++) {
                if (index >= count) {
                    break;
                }

                int x = j * mCellWidth + (j + 1) * this.horizontalSpace;
                int y = i * mCellHeight + (i + 1) * this.vecitcalSpace;
                int width = mCellWidth;
                int height = mCellHeight;

                final View child = getChildAt(index);

                if (child.getVisibility() != View.GONE) {
                    child.layout(x, y, x + width, y + height);
                }

                index++;
            }
        }
    }

    public void setHorizontalSpace(int space) {
        this.horizontalSpace = space;
    }

    public void setVecticalSpace(int space) {
        this.vecitcalSpace = space;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

}
