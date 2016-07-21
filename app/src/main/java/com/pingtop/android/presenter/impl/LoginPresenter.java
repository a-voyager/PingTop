package com.pingtop.android.presenter.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.pingtop.android.base.IView;
import com.pingtop.android.entities.global.UserEntity;
import com.pingtop.android.entities.response.RegisterResponse;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.ILoginView;
import com.pingtop.android.manager.DataManager;
import com.pingtop.android.manager.HttpHelper;
import com.pingtop.android.presenter.IPresenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by wuhaojie on 2016/7/21 8:49.
 */
public class LoginPresenter implements IPresenter {

    private Context mContext;
    private ILoginView mLoginView;

    @Inject
    public LoginPresenter(@ContextLifeCycle("Activity") Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void attachView(IView v) {
        mLoginView = (ILoginView) v;
    }

    public void clickLogin() {
        mLoginView.showDialog();
        HttpHelper httpHelper = DataManager.getHttpHelper();
        httpHelper.register("test", "test", new Subscriber<RegisterResponse>() {
            @Override
            public void onCompleted() {
                mLoginView.dismissDialog();
//                mLoginView.showSnackBarMsg("登录成功!");
                EventBus.getDefault().postSticky(new UserEntity());
                ((Activity) mContext).finish();
            }

            @Override
            public void onError(Throwable e) {
                mLoginView.dismissDialog();
                mLoginView.showSnackBarMsg("登录失败!");
            }

            @Override
            public void onNext(RegisterResponse registerResponse) {
                Log.e("LoginPresenter", registerResponse.toString());
            }
        });
    }
}
