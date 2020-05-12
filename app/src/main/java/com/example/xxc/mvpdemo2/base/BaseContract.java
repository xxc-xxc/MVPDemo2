package com.example.xxc.mvpdemo2.base;

import com.example.xxc.mvpdemo2.bean.BaseBean;

/**
 * MVP一个协调接口
 */
public interface BaseContract {

    interface BaseModel {

    }

    interface BaseView {
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

    interface BasePresenter {

    }

}
