package com.hua.zhbj.adapter;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



import java.util.ArrayList;

/**
 * Created by Spring on 2015/8/7.
 * ViewPager 适配器
 */
public class GuideAdapter extends PagerAdapter{
    private ArrayList<ImageView> mImageViewlist;

    public GuideAdapter(ArrayList<ImageView> mImageViewlist) {
        this.mImageViewlist = mImageViewlist;
    }


    @Override
    public int getCount() {
        return mImageViewlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /**
     * initial the view
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mImageViewlist.get(position));

        return mImageViewlist.get(position);

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


}
