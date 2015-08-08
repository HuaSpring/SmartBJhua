package com.hua.zhbj.base.menudetail;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hua.zhbj.R;
import com.hua.zhbj.base.BaseMenuDetailPager;

/**
 * Created by Spring on 2015/8/8.
 * 菜单详情页-新闻
 */
public class NewsMenuDetailPager extends BaseMenuDetailPager {
    private ViewPager mViewPager;

    public NewsMenuDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initViews() {

        // 加载自己的新的布局

        View view = View.inflate(mActivity, R.layout.news_menu_detail, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_menu_detail);

        return view;


        /*TextView text = new TextView(mActivity);
        text.setText("菜单详情页-专题");
        text.setTextSize(30);
        text.setTextColor(Color.RED);
        text.setGravity(Gravity.CENTER);
        return text;*/
    }

    @Override
    public void initData() {
        mViewPager.setAdapter(new MenuDetailAdapter());
    }

    class MenuDetailAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
