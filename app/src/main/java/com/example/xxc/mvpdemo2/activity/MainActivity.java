package com.example.xxc.mvpdemo2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.xxc.mvpdemo2.R;
import com.example.xxc.mvpdemo2.bean.BaseBean;
import com.example.xxc.mvpdemo2.presenter.MainPresenter;
import com.example.xxc.mvpdemo2.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainPresenter presenter = new MainPresenter(this);
        presenter.login("xxc", "123");
    }

    @Override
    public void onLoginSuccess(BaseBean<Object> model) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onErrorCode(BaseBean model) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onProgress(int progress) {

    }
}
