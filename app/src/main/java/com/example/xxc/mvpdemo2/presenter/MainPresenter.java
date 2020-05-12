package com.example.xxc.mvpdemo2.presenter;

import com.example.xxc.mvpdemo2.base.BaseObserver;
import com.example.xxc.mvpdemo2.bean.BaseBean;
import com.example.xxc.mvpdemo2.view.MainView;

public class MainPresenter extends BasePresenter<MainView> {
    public MainPresenter(MainView baseView) {
        super(baseView);
    }

    public void login(String username, String password) {
        addDisposable(apiService.login(username, password), new BaseObserver() {
            @Override
            public void onSuccess(BaseBean o) {
                baseView.onLoginSuccess(o);
            }

            @Override
            public void onError(String msg) {

            }

            @Override
            public void onNext(Object o) {

            }
        });
    }
}
