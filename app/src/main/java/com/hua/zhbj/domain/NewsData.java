package com.hua.zhbj.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Spring on 2015/8/8.
 * 网络 分类 信息的封装
 */
public class NewsData {

    // gson 要求这些字段的名字必须和服务器返回的字段一致，，因为gson会在底层完成一些复制功能，这样才会方便gson解析
    public int retcode;

    public ArrayList<NewsMenuData> data;

    // 侧边栏数据对象
   public class NewsMenuData{
        public String id;
        public  String title;
        public int type;
        public String url;
        // public String url1;

        public ArrayList<NewsTabData> children;

        @Override
        public String toString() {
            return "NewsMenuData{" +
                    "title='" + title + '\'' +
                    ", children=" + children +
                    '}';
        }
    }
    // 新闻页面下11个子页签：北京 ， 中国，国际，体育等
   public class NewsTabData{
        public String id;
        public  String title;
        public int type;
        public String url;

        @Override
        public String toString() {
            return "NewsTabData{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NewsData{" +
                "data=" + data +
                '}';
    }
}
