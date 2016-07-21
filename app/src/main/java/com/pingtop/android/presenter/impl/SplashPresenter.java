package com.pingtop.android.presenter.impl;

import android.content.Context;
import android.os.Bundle;

import com.pingtop.android.base.IView;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.ISplashView;
import com.pingtop.android.presenter.IPresenter;

import javax.inject.Inject;

/**
 * Created by wuhaojie on 2016/7/21 9:14.
 */
public class SplashPresenter implements IPresenter {
    private Context mContext;
    private ISplashView mSplashView;

    @Inject
    public SplashPresenter(@ContextLifeCycle("Activity") Context context) {
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
        mSplashView = (ISplashView) v;
    }
}
