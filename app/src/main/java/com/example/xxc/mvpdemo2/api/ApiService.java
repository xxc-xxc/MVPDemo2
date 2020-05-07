package com.example.xxc.mvpdemo2.api;

import com.example.xxc.mvpdemo2.base.BaseModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("/api/login/")
    Observable<BaseModel<Object>> login(@Field("username") String username, @Field("password") String password);
    
}
