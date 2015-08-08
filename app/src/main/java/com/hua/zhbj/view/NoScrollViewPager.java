package com.hua.zhbj.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Spring on 2015/8/8.
 * 不能滑的 ViewPage
 */
public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(Context context) {
        super(context);


    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *  重写 onTouchEvent，直接改为fales, 让他不能滑动
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
