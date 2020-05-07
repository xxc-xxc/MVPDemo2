package com.example.xxc.mvpdemo2.api;

import com.example.xxc.mvpdemo2.MyApplication;
import com.example.xxc.mvpdemo2.base.BaseContent;
import com.example.xxc.mvpdemo2.cookie.CookieManger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {

    private static ApiRetrofit instance;

    private static final int DEFAULT_TIMEOUT = 15;
    public static String mBaseUrl = BaseContent.baseUrl;
    private Retrofit retrofit;
    private ApiService apiService;

    private ApiRetrofit() {
    }

    public static ApiRetrofit getInstance() {
        if (instance == null) {
            synchronized (ApiRetrofit.class) {
                if (instance == null) {
                    instance = new ApiRetrofit();
                }
            }
        }

        return instance;
    }

    public ApiService getApiService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cookieJar(new CookieManger(MyApplication.getContext()))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        return apiService;
    }

}
