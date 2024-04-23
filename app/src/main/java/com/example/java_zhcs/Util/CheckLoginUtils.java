package com.example.java_zhcs.Util;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.java_zhcs.login.LoginActivity;

public class CheckLoginUtils {

    /**
     * 判断用户是否属于登录状态
     * @param context
     * @param autoLogin
     * @param callback
     */
    public static void isLogin(Context context, Boolean autoLogin, CheckLogin callback){

        if (App.getToken() != null){
            callback.onAlready();
        }else {
            if (autoLogin){
//                "用户未登录，即将返回登录"
                App.Toast("用户未登录，即将跳转到登录");

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        context.startActivity(new Intent(context, LoginActivity.class));
                    }
                }, 700);
            }else {
                callback.onNone();
            }
        }

    }


    public interface CheckLogin {

        void onAlready();
        void onNone();
    }
}
