package com.hua.zhbj.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


import com.hua.zhbj.R;
import com.hua.zhbj.base.BasePager;
import com.hua.zhbj.base.pagers.GovAffairsPager;
import com.hua.zhbj.base.pagers.HomePager;
import com.hua.zhbj.base.pagers.NewsCenterPager;
import com.hua.zhbj.base.pagers.SettingPager;
import com.hua.zhbj.base.pagers.SmartServicePager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spring on 2015/8/7.
 */
public class ContentFragment extends BaseFragment {
    @ViewInject(R.id.rg_group)      // 添加注解，相当于findViewById();
    private RadioGroup rgGroup;
    @ViewInject(R.id.vp_content)
    private ViewPager mViewPager;

    private List<BasePager> mPagerList;


    @Override
    public View initViews() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        //  rgGroup = (RadioGroup) view.findViewById(R.id.rg_group);
        ViewUtils.inject(this, view);

        return view;
    }

    public void initData() {

        rgGroup.check(R.id.rb_home);   // 默认勾选首页

        // 初始化5个子页
        mPagerList = new ArrayList<>();
        mPagerList.add(new HomePager(mActivity));
        mPagerList.add(new NewsCenterPager(mActivity));
        mPagerList.add(new SmartServicePager(mActivity));
        mPagerList.add(new GovAffairsPager(mActivity));
        mPagerList.add(new SettingPager(mActivity));

        mViewPager.setAdapter(new ContentAdapter());

        // 为 RadioGroup 设置监听
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        mViewPager.setCurrentItem(0,true);    // 设置当前页
                        break;
                    case R.id.rb_news:
                        mViewPager.setCurrentItem(1,true);
                        break;
                    case R.id.rb_smart:
                        mViewPager.setCurrentItem(2,true);
                        break;
                    case R.id.rb_gov:
                        mViewPager.setCurrentItem(3,true);
                        break;
                    case R.id.rb_setting:
                        mViewPager.setCurrentItem(4,true);
                        break;
                    default:
                        break;
                }
            }
        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 获取当前先中的页面，然后初始化该页面数据
               mPagerList.get(position).initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mPagerList.get(0).initData();
    }


    class ContentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mPagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagerList.get(position);
            container.addView(pager.mRootView);
            // 在页面初始化中，初始化数据，如果放在此处，则会预加载下一个页面，，会导致当前设置的侧滑失败
            // pager.initData();
            return pager.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
