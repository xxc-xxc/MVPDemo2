package com.example.xxc.mvpdemo2.presenter;

import com.example.xxc.mvpdemo2.api.ApiRetrofit;
import com.example.xxc.mvpdemo2.api.ApiService;
import com.example.xxc.mvpdemo2.base.BaseObserver;
import com.example.xxc.mvpdemo2.base.FileObserver;
import com.example.xxc.mvpdemo2.view.BaseView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BasePresenter<T extends BaseView> {

    /**
     * 问题：UI层destroy了，订阅没有及时取消，可能会造成内存泄漏
     * 解决：
     *  1.UI创建时实例化CompositeDisposable
     *  2.subscribe订阅返回的Disposable对象加入管理器
     *  3.UI销毁时清空订阅对象
     *  --- 解决内存泄漏
     *  --- 统一管理订阅
     *  --- 将网络请求与UI的生命周期绑定（同生共死）
     */
    private CompositeDisposable compositeDisposable;

    public T baseView;
    protected ApiService apiService = ApiRetrofit.getInstance().getApiService();

    public BasePresenter(T baseView) {
        this.baseView = baseView;
    }

    public void detachView() {
        this.baseView = null;
        removeDisposable();
    }

    public void addDisposable(Observable<?> observable, BaseObserver observer) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(observer));
    }

    public void addFileDisposable(Observable<?> observable, FileObserver observer) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer));
    }

    public void removeDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

}
