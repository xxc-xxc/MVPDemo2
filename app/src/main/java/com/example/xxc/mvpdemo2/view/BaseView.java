package com.example.xxc.mvpdemo2.view;

import com.example.xxc.mvpdemo2.bean.BaseBean;

public interface BaseView {

    void onSuccess(Object o);
    void onError(Throwable throwable);
    //显示dialog
    void showLoading();
    //隐藏 dialog
    void hideLoading();
    //显示错误信息
    void showError(String msg);
    //错误码
    void onErrorCode(BaseBean model);
    //进度条显示
    void showProgress();
    //进度条隐藏
    void hideProgress();
    //文件下载进度监听
    void onProgress(int progress);

}
