package com.hua.zhbj.fragment;


import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.hua.zhbj.R;
import com.hua.zhbj.activity.MainActivity;
import com.hua.zhbj.base.pagers.NewsCenterPager;
import com.hua.zhbj.domain.NewsData;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by Spring on 2015/8/7.
 */
public class LeftMenuFragment extends BaseFragment {
    ArrayList<NewsData.NewsMenuData> mMenuList;

    MenuAdapter adapter = new MenuAdapter();

    @ViewInject(R.id.lv_menu)
    private ListView lvMenu;
    // 当前被点击的位置
    private int mCurrentPos;

    @Override
    public View initViews() {
        View view =  View.inflate(mActivity,R.layout.fragment_left_menu,null);
        ViewUtils.inject(this,view );
        return view;
    }

    @Override
    public void initData() {
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrentPos = position;
                adapter.notifyDataSetChanged();

                setCurrentMenuDetailPager(position);



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

    protected void setCurrentMenuDetailPager(int position) {
        MainActivity mainUi = (MainActivity) mActivity;
        ContentFragment contentFragment = mainUi.getContentFragment();           // 获取主页面fragment
        NewsCenterPager newsCenterPager = contentFragment.getNewsCenterPager();  // 获取新闻中心页面
        newsCenterPager.setCurrentMenuDetailPager(position);                     // 设置详情页
    }

    // 设置网络数据
    public void setMenuData(NewsData data){
        mMenuList = data.data;  // 拿到数据

        lvMenu.setAdapter(adapter);

    }



    // 侧边栏数据适配器
    class MenuAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mMenuList.size();
        }

        @Override
        public Object getItem(int position) {
            return mMenuList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(mActivity, R.layout.list_menu_item, null);
            TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
            NewsData.NewsMenuData newsMenuData = mMenuList.get(position);
            String title = newsMenuData.title;


            tvTitle.setText(title);

            if(mCurrentPos == position){
                tvTitle.setTextColor(Color.RED);
            }else{
                tvTitle.setTextColor(Color.WHITE);
            }

            return view;
        }
    }
}
