package com.hua.zhbj.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Spring on 2015/8/7.
 */
public class PrefUtils{
   public static final String PREF_NAME = "config";

    public static boolean getBoolean(Context ctx,String key,boolean defaultValue){
    SharedPreferences sp = ctx.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
       return sp.getBoolean(key,defaultValue);
    }

    public static void  setBoolean(Context ctx,String key,boolean defaultValue){
        SharedPreferences sp = ctx.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,defaultValue).commit();

    }

}