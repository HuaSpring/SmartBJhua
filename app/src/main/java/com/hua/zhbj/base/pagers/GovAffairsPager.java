package com.hua.zhbj.base.pagers;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.hua.zhbj.base.BasePager;

/**
 * Created by Spring on 2015/8/8.
 * 首页实现
 */
public class GovAffairsPager extends BasePager {
    public GovAffairsPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public void initData() {

        tvTitle.setText("人口管理");
        setSlidingMenuEnable(true);
        TextView text = new TextView(mActivity);
        text.setText("政务");
        text.setTextSize(30);
        text.setTextColor(Color.RED);
        text.setGravity(Gravity.CENTER);
        // 向framelayout中动态增加内容
        flContent.addView(text);
    }
}
