package com.hua.zhbj.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hua.zhbj.R;
import com.hua.zhbj.activity.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by Spring on 2015/8/8.
 */
public class BasePager {
    public Activity mActivity;
    public View mRootView;     // 布局对象
    public TextView tvTitle;   // 标题
    public FrameLayout flContent; // 内容主体
    public ImageButton btnMenu;   // 菜单内容

    public BasePager(Activity mActivity) {
        this.mActivity = mActivity;
        initViews();

    }

    /**
     * 初始化布局
     */
    public void initViews() {

        mRootView = View.inflate(mActivity, R.layout.base_pager, null);
        tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
        flContent = (FrameLayout) mRootView.findViewById(R.id.fl_content);
        btnMenu = (ImageButton) mRootView.findViewById(R.id.btn_menu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSlidingMenu();
            }
        });
    }

    /**
     * 切换SlidingMenu的状态
     */
    protected  void toggleSlidingMenu(){
        MainActivity mainUi = (MainActivity) mActivity;
        SlidingMenu slidingMenu = mainUi.getSlidingMenu();
        slidingMenu.toggle(); // 切换状态，显示时隐藏，隐藏时显示
    }

    /**
     * 初始化数据
     */
    public void initData() {

    }
    /**
     * 设置侧边栏开启或关闭
     * @param b
     */
    protected void setSlidingMenuEnable(boolean b){
        MainActivity mainUI = (MainActivity) mActivity;
        SlidingMenu slidingMenu = mainUI.getSlidingMenu();
        if(b) {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }else{
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
    }
}

