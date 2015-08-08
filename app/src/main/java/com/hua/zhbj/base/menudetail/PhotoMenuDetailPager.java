package com.hua.zhbj.base.menudetail;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.hua.zhbj.base.BaseMenuDetailPager;

/**
 * Created by Spring on 2015/8/8.
 * 组图详情页-组图
 */
public class PhotoMenuDetailPager extends BaseMenuDetailPager {


    public PhotoMenuDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initViews() {
        TextView text = new TextView(mActivity);
        text.setText("组图详情页-专题");
        text.setTextSize(30);
        text.setTextColor(Color.RED);
        text.setGravity(Gravity.CENTER);
        return text;
    }
}
