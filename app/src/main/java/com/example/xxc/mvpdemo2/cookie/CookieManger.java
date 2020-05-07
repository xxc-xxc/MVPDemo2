package com.example.xxc.mvpdemo2.cookie;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;


import org.jetbrains.annotations.NotNull;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * File descripition: cookie 处理
 *
 * @date 2018/7/2
 */
public class CookieManger implements CookieJar {
    private Context mContext;

    private static PersistentCookieStore cookieStore;

    public CookieManger(Context context) {
        mContext = context;
        if (cookieStore == null) {
            cookieStore = new PersistentCookieStore(mContext);
        }
    }

    @Override
    public void saveFromResponse(@NotNull HttpUrl url, @NotNull List<Cookie> cookies) {
        if (cookies.size() > 0) {
            for (Cookie item : cookies) {
                cookieStore.add(url, item);
                item.name();
                if (!TextUtils.isEmpty(item.name())) {
                    item.value();
                    if (!TextUtils.isEmpty(item.value())) {
                        /*保存cookie到sp地方  可能会用到 */
                        //                    PrefUtils.setString(mContext, "cookie_name", item.name());
                        //                    PrefUtils.setString(mContext, "cookie_value", item.value());
                    }
                }
            }
        }
    }

    @NotNull
    @Override
    public List<Cookie> loadForRequest(@NotNull HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        for (int i = 0; i < cookies.size(); i++) {
            Log.e("", "拿出来的cookies name()==" + cookies.get(i).name());
            Log.e("", "拿出来的cookies value()==" + cookies.get(i).value());
        }
        return cookies;
    }

}
