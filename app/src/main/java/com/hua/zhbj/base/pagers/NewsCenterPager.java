package com.hua.zhbj.base.pagers;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hua.zhbj.activity.MainActivity;
import com.hua.zhbj.base.BaseMenuDetailPager;
import com.hua.zhbj.base.BasePager;
import com.hua.zhbj.base.menudetail.InteractMenuDetailPager;
import com.hua.zhbj.base.menudetail.NewsMenuDetailPager;
import com.hua.zhbj.base.menudetail.PhotoMenuDetailPager;
import com.hua.zhbj.base.menudetail.TopicMenuDetailPager;
import com.hua.zhbj.domain.NewsData;
import com.hua.zhbj.fragment.LeftMenuFragment;
import com.hua.zhbj.global.GlobalContants;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;

/**
 * Created by Spring on 2015/8/8.
 * 首页实现
 */
public class NewsCenterPager extends BasePager {
    private ArrayList<BaseMenuDetailPager> menuDetailList;

    private NewsData mNewsData;
    public NewsCenterPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public void initData() {

        getDataFromServer();
    }

    /**
     * 从服务器获取数据
     */
    private void getDataFromServer() {
        HttpUtils utils = new HttpUtils();

        // 使用xutils 发送请求
        utils.send(HttpRequest.HttpMethod.GET, GlobalContants.CATEGORIES_URL,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String result = responseInfo.result;
                        // System.out.println(result);
                        // 解析 json 数据
                        parseJson(result);
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        System.out.println(s);
                        e.printStackTrace();
                    }
                });
    }

    /**
     * 使用 Gson 解析 json 数据
     */
    protected void parseJson(String result){
        Gson gson = new Gson();
        // 定义一个bean NewsData
        mNewsData = gson.fromJson(result, NewsData.class);
       //  System.out.println("解析结果：" + newsData);

        // 刷新侧边栏数据
        MainActivity mainActivity = (MainActivity) mActivity;
        LeftMenuFragment leftMenuFragment = mainActivity.getLeftMenuFragment();
        leftMenuFragment.setMenuData(mNewsData);

        // 准备4个详情页
        menuDetailList = new ArrayList<>();

        menuDetailList.add(new NewsMenuDetailPager(mActivity));
        menuDetailList.add(new InteractMenuDetailPager(mActivity));
        menuDetailList.add(new PhotoMenuDetailPager(mActivity));
        menuDetailList.add(new TopicMenuDetailPager(mActivity));

        // 设置菜单详情页为默认当前页
        setCurrentMenuDetailPager(0);
    }

    /**
     * 设置当前菜单详情页
     */
    public void setCurrentMenuDetailPager(int position){
        BaseMenuDetailPager baseMenuDetailPager = menuDetailList.get(position);
        flContent.removeAllViews();                                // 清除之前的所有布局
        flContent.addView(baseMenuDetailPager.mrootView);
        NewsData.NewsMenuData newsMenuData = mNewsData.data.get(position);
        tvTitle.setText(newsMenuData.title);
    }
}
