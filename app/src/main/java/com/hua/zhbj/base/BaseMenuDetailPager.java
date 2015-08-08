package com.hua.zhbj.base;

import android.app.Activity;
import android.view.View;

/**
 * Created by Spring on 2015/8/8.
 */
public abstract class BaseMenuDetailPager {
    public Activity mActivity;
    public View mrootView;
    public BaseMenuDetailPager(Activity activity) {
        this.mActivity = activity;
        this.mrootView = initViews();
    }

    public abstract View initViews();

    public void initData(){

    }
}
