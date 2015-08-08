package com.hua.zhbj.base.pagers;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.hua.zhbj.base.BasePager;

/**
 * Created by Spring on 2015/8/8.
 * 首页实现
 */
public class SettingPager extends BasePager {
    public SettingPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public void initData() {

        btnMenu.setVisibility(View.GONE);
        setSlidingMenuEnable(false);
        tvTitle.setText("设置");

        TextView text = new TextView(mActivity);
        text.setText("设置");
        text.setTextSize(30);
        text.setTextColor(Color.RED);
        text.setGravity(Gravity.CENTER);
        // 向framelayout中动态增加内容
        flContent.addView(text);
    }
}
