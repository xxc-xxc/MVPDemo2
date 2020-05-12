package com.example.xxc.mvpdemo2;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private Context mContext;
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Application getApplication() {
        if (application == null) {
            synchronized (MyApplication.class) {
                if (application == null) {
                    application = new MyApplication();
                }
            }
        }

        return application;
    }
}
