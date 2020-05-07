package com.example.xxc.mvpdemo2;

import android.app.Application;
import android.content.Context;

import java.math.MathContext;

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
