package com.pingtop.android.views.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.WindowManager;

import com.pingtop.android.R;
import com.pingtop.android.base.BaseActivity;
import com.pingtop.android.base.BaseApplication;
import com.pingtop.android.injector.component.ActivityComponent;
import com.pingtop.android.injector.component.DaggerActivityComponent;
import com.pingtop.android.injector.module.ActivityModule;
import com.pingtop.android.interfaces.ISplashView;
import com.pingtop.android.presenter.impl.SplashPresenter;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements ISplashView {

    @Inject
    SplashPresenter mSplashPresenter;

    @Override
    protected void initializePresenter() {
        mSplashPresenter.attachView(this);
    }

    @Override
    public void initializeInjector() {
        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .appComponent(((BaseApplication) getApplication()).getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
        activityComponent.inject(this);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_splash;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        initWindow();
        mSplashPresenter.onCreate(savedInstanceState);
    }

    @TargetApi(19)
    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    public void showSnackBarMsg(@StringRes int msg) {

    }

    @Override
    public void showSnackBarMsg(String msg) {

    }
}
