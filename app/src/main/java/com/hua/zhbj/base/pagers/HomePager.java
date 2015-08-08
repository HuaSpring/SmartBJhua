package com.hua.zhbj.base.pagers;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.hua.zhbj.activity.MainActivity;
import com.hua.zhbj.base.BasePager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by Spring on 2015/8/8.
 * 首页实现
 */
public class HomePager extends BasePager {
    public HomePager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public void initData() {

        tvTitle.setText("智慧北京");
        btnMenu.setVisibility(View.GONE);
        setSlidingMenuEnable(false);
        TextView text = new TextView(mActivity);
        text.setText("首页");
        text.setTextSize(30);
        text.setTextColor(Color.RED);
        text.setGravity(Gravity.CENTER);
        // 向framelayout中动态增加内容
        flContent.addView(text);
    }


}
