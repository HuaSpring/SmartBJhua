package com.hua.zhbj.activity;


import android.app.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hua.zhbj.R;
import com.hua.zhbj.adapter.GuideAdapter;
import com.hua.zhbj.utils.PrefUtils;

import java.util.ArrayList;

public class GuideActivity extends Activity {
    private ArrayList<ImageView> mImageViewlist;
    private static final int[] mImageIds = new int[]{R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};
    private ViewPager vpGuide;
    private Button btStart;
    private View viewRedPoint;
    private LinearLayout llPointGroup; // 引导小圆点的父控件
    private int mPointWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        vpGuide = (ViewPager) findViewById(R.id.vp_guide);
        btStart = (Button) findViewById(R.id.bt_start);
        llPointGroup = (LinearLayout) findViewById(R.id.ll_point_group);
        viewRedPoint = findViewById(R.id.viewRedPoint);
        initViews();
        // PagerAdapter
        vpGuide.setAdapter(new GuideAdapter(mImageViewlist));
        vpGuide.setOnPageChangeListener(new GuidePageListener());
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefUtils.setBoolean(GuideActivity.this,"is_user_showed_guide",true);
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    /**
     * initial the views
     */
    private void initViews() {

        mImageViewlist = new ArrayList<>();

        // LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10,10);
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView image = new ImageView(this);
            // set background
            image.setBackgroundResource(mImageIds[i]);
            mImageViewlist.add(image);
        }

        // 初始化引导页的小圆点
        for (int i = 0; i < mImageIds.length; i++) {
            View point = new View(this);
            point.setBackgroundResource(R.drawable.shape_pointer_gray);// 设置引导页默认圆点

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    20, 20);
            if (i > 0) {
                params.leftMargin = 20;// 设置圆点间隔
            }

            point.setLayoutParams(params);// 设置圆点的大小

            llPointGroup.addView(point);// 将圆点添加给线性布局
        }

        //获取视图树，对Layout结束事件进行监听
        llPointGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                 mPointWidth = llPointGroup.getChildAt(1).getLeft() - llPointGroup.getChildAt(0).getLeft();
            }
        });
    }




    //  为　viewPagers 设置监听
    class GuidePageListener implements ViewPager.OnPageChangeListener {

        /**
         * This method will be invoked when the current page is scrolled, either as part
         * of a programmatically initiated smooth scroll or a user initiated touch scroll.
         *
         * @param position             Position index of the first page currently being displayed.
         *                             Page position+1 will be visible if positionOffset is nonzero.
         * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
         * @param positionOffsetPixels Value in pixels indicating the offset from position.
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            int len = (int) (mPointWidth*position + mPointWidth*positionOffset);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewRedPoint.getLayoutParams();
            params.leftMargin = len;
            viewRedPoint.setLayoutParams(params);
            if (position < mImageIds.length - 1) {
                btStart.setVisibility(View.INVISIBLE);
            } else {
                btStart.setVisibility(View.VISIBLE);
            }
        }

        /**
         * This method will be invoked when a new page becomes selected. Animation is not
         * necessarily complete.
         *
         * @param position Position index of the new selected page.
         */
        @Override
        public void onPageSelected(int position) {

        }

        /**
         * Called when the scroll state changes. Useful for discovering when the user
         * begins dragging, when the pager is automatically settling to the current page,
         * or when it is fully stopped/idle.
         *
         * @param state The new scroll state.
         * @see ViewPager#SCROLL_STATE_IDLE
         * @see ViewPager#SCROLL_STATE_DRAGGING
         * @see ViewPager#SCROLL_STATE_SETTLING
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
