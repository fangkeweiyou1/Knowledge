package com.module_customview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by zhangyuncai on 2017/6/22.
 * 监听HorizontalScrollView左右滑动坐标的
 */

public class MoveHorizontalScrollView extends HorizontalScrollView {
    private ScrollViewListener scrollViewListener = null;

    public MoveHorizontalScrollView(Context context) {
        super(context);
    }

    public MoveHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 这个监听顶部新旧x,y坐标
     */
    public interface ScrollViewListener {
        void onScrollChanged(int x, int y, int oldx, int oldy);

    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(x, y, oldx, oldy);
        }
    }
}
