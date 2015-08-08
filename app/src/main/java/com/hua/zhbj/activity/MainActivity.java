package com.hua.zhbj.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;


import com.hua.zhbj.R;
import com.hua.zhbj.fragment.ContentFragment;
import com.hua.zhbj.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
    private static final String FRAME_LEFT_MENU = "frame_left_menu";
    private static final String FRAME_CONTENT = "frame_content";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.left_menu);// 设置侧边栏
        SlidingMenu slidingMenu = getSlidingMenu();// 获取侧边栏对象
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 设置全屏触摸
        slidingMenu.setBehindOffset(400);// 设置预留屏幕的宽度

        initFragment();

    }

    /**
     * 初始化Fragment 填充数据
     */
    private void initFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
       transaction.replace(R.id.fl_left_menu, new LeftMenuFragment(), FRAME_LEFT_MENU);
        transaction.replace(R.id.fl_content, new ContentFragment(), FRAME_CONTENT);

        transaction.commit();

       //  Fragment fragmentById = fm.findFragmentById();


    }

    // 获取主体内容
    public ContentFragment getContentFragment(){
        FragmentManager fm = getFragmentManager();
        ContentFragment contentFragment= (ContentFragment) fm.findFragmentByTag(FRAME_CONTENT);
        return contentFragment;
    }
    // 获取侧边栏对象
    public LeftMenuFragment getLeftMenuFragment(){
        FragmentManager fm = getFragmentManager();
        LeftMenuFragment leftFragment= (LeftMenuFragment) fm.findFragmentByTag(FRAME_LEFT_MENU);
        return leftFragment;
    }


    /**
     * 如何用库，操作侧滑菜单
     */
    private void HowtoUse() {


        setBehindContentView(R.layout.left_menu);                // 设置侧边栏布局
        SlidingMenu menu = getSlidingMenu();                     // 获取侧边栏对象
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 设置全屏触摸

        menu.setSecondaryMenu(R.layout.right_menu);              // 设置右侧边栏
        menu.setMode(SlidingMenu.LEFT_RIGHT);                    // 设置展现模式
        menu.setBehindWidth(200);                                // 设置预留屏蔽的宽度
    }


}
