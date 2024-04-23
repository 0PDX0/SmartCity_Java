package com.example.java_zhcs.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {

    private static SharedPreferences sp;

    /**
     * 初始化共享参数
     */
    public static void init(Context context){
        //获取共享参数
        sp = context.getSharedPreferences("zhcs", Context.MODE_PRIVATE);
    }

    /**
     * 存储数据进共享参数
     */
    public static void put(String s, String v){

        sp.edit().putString(s, v).apply();
    }

    /**
     * 从共享参数获取数据
     */
    public static String get(String s){

        return sp.getString(s,null);
    }


    /**
     * 从共享参数删除数据
     */
    public static void delete(String s){

        sp.edit().remove(s).apply();

    }

}





























