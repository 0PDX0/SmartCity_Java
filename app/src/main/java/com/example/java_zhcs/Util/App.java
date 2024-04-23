package com.example.java_zhcs.Util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class App extends Application {

    public static String url = "http://124.93.196.45:10001/";
    @SuppressLint("StaticFieldLeak")
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        /*初始化共享参数*/
        SPUtil.init(context);

        /*初始化网络请求类*/
        RetrofitUtil.init(context);
    }

    /**
     * 获取Token
     */
    public static String getToken(){
        return SPUtil.get("token");
    }

    /**
     * 关闭输入法
     * @param activity
     */
    public static void hiddenKeyboard(Activity activity){

        //INPUT_METHOD_SERVICE：输入法服务
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);

        View v = activity.getWindow().peekDecorView();

        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

    }

    /**
     * 弹窗提示
     */
    public static void startAppShow(Context context){

        new AlertDialog.Builder(context)
                .setMessage("开源")
                .show();

    }

    /**
     * 提示
     * @param msg
     */
    public static void Toast(String msg){

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }

}
























