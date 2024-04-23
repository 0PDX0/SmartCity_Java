package com.example.java_zhcs.Util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 封装网络请求类
 */
public class RetrofitUtil {

    @SuppressLint("StaticFieldLeak")    //进行检测，防止内存泄漏问题
    private static Context context;

    private static RetrofitService service;

    public static void init(Context context_init){

        context = context_init;
        //这里我直接使用App.url放入进去构造了
        service = new Retrofit.Builder().baseUrl(App.url).build().create(RetrofitService.class);

    }

    /*实用*/
    public interface OnRequest{
        void onRequest(String json);
    }

    /**
     * GET请求的封装
     * @param url
     * @param onRequest
     */
    public static void get(final String url, final OnRequest onRequest){
        Log.e("pdxcs",url + "##" + App.getToken());
        service.get(url, App.getToken()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                    String string = response.body().string();

                    //string.replaceAll：字符串替换，好像是因为图片地址的问题
//                    string = string.replaceAll("/dev-api", "/prod-api");

                    //将返回回来的字符串返回回去供调用者使用
                    onRequest.onRequest(string);

                } catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                App.Toast("网络错误" + throwable.toString());
            }
        });
    }


    /**
     * Post请求的封装
     * @param url
     * @param map
     * @param onRequest
     */
    public static void post(String url, Map map, final OnRequest onRequest){

        //构造一个RequestBody作为请求参数，第一个参数(MediaType)代表我们要发送的数据的媒体类型
        MediaType mediaType = MediaType.Companion.parse("application/json;charset=utf-8");
        /*TODO 这个create报错必须再引入okio的包???*/
        RequestBody body = RequestBody.Companion.create(new JSONObject(map).toString(), mediaType);

        MultipartBody requestBody = null;
        /*-----------------------------------------------------------------------------------------------------*/
        if (url.equals("/prod-api/common/upload")){
            //multipart/form-data
            mediaType = MediaType.Companion.parse("multipart/form-data;boundary=splitTag");   //;boundary=splitTag
            body = RequestBody.Companion.create(new File("src/main/res/mipmap-xxxhdpi/djsy.jpg"),mediaType);

            File file = new File("src/main/res/mipmap-xxxhdpi/djsy.jpg");

            requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file", file.getName(), body)
                    .build();
        }

        service.post(url, App.getToken(), body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    //直接返回结果
                    onRequest.onRequest(response.body().string());
                }catch (IOException e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                App.Toast("网络连接错误" + throwable.toString());
                Log.e("pdx",throwable.toString());
            }
        });
    }

}








































