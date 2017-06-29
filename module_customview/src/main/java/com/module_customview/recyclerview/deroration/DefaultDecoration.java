package com.module_customview.recyclerview.deroration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.commonlibs.utils.LogUtils;

/**
 * Created by zhangyuncai on 2017/6/29.
 */

public class DefaultDecoration extends RecyclerView.ItemDecoration {

    private int mHeight = 5; //分割线高度
    private Paint mPaint;

    public DefaultDecoration() {
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#00000000"));
    }

    /**
     * 首先是画分割线,再画item,再绘制onDrawOver,所以绘制分割线的时候,需要偏移
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (position != 0) {//这个表示如果是第一个item,就不用往下移动距离mHeight
            //第一个item预留空间
//            outRect.top = mHeight;
        }
        outRect.top = mHeight;
        LogUtils.i("<<<>>>","--");
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        /*
        分割线实质上是一个矩形Rect,
        获取当前RecyclerView的Item数量，遍历每个Item。在对应的位置绘制一个高度为mHeight的矩形 ，从而实现分割线的效果。
         */
        final int left = parent.getLeft();//分割线左坐标点
        final int right = parent.getRight();//分割线右坐标点
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View childView = parent.getChildAt(i);
            final int bottom = childView.getTop();//分割线实在item之上的,所以item的上坐标就是分割线的下坐标
            final int top = bottom - mHeight;
            if (i % 2 == 0)
                mPaint.setColor(Color.RED);
            else mPaint.setColor(Color.GREEN);
            c.drawRect(left, top, right, bottom, mPaint);
        }
    }

}
