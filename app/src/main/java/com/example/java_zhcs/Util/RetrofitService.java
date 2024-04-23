package com.example.java_zhcs.Util;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

/**
 * Retrofit将 Http请求 抽象成 Java接口：采用 注解 描述网络请求参数 和配置网络请求参数
 */
public interface RetrofitService {

    /*@Header：请求头携带参数，参数名("Authorization"),参数值 String token, @Body请求正文，正文Body*/
    /*@Url	标志参数用来替换请求路径，会忽略baseUrl,也就是初始化这个网络请求类时的baseUrl()中的路径*/
    @GET
    Call<ResponseBody> get(@Url String url, @Header("Authorization") String token);

    @PUT
    Call<ResponseBody> put(@Url String url, @Header("Authorization") String token, @Body RequestBody body);

    @POST
    Call<ResponseBody> post(@Url String url, @Header("Authorization") String token, @Body RequestBody body);

    @DELETE
    Call<ResponseBody> delete(@Url String url, @Header("Authorization") String token, @Body RequestBody body);

//    @POST
//    Call<ResponseBody> postFile(@Multipart MultipartBody body);
}

























