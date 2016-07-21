package com.pingtop.android.presenter.impl;

import android.content.Context;
import android.os.Bundle;

import com.pingtop.android.base.IView;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.ILoginView;
import com.pingtop.android.presenter.IPresenter;

import javax.inject.Inject;

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
}
