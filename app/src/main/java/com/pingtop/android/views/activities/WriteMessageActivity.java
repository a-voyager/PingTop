package com.pingtop.android.views.activities;

import android.os.Bundle;
import android.support.annotation.StringRes;

import com.pingtop.android.R;
import com.pingtop.android.base.BaseActivity;
import com.pingtop.android.base.BaseApplication;
import com.pingtop.android.injector.component.ActivityComponent;
import com.pingtop.android.injector.component.DaggerActivityComponent;
import com.pingtop.android.injector.module.ActivityModule;
import com.pingtop.android.interfaces.IWriteView;
import com.pingtop.android.presenter.impl.WritePresenter;

import javax.inject.Inject;

public class WriteMessageActivity extends BaseActivity implements IWriteView {

    @Inject
    WritePresenter mWritePresenter;

    @Override
    protected void initializePresenter() {
        mWritePresenter.attachView(this);
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
        return R.layout.activity_write_message;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mWritePresenter.onCreate(savedInstanceState);
    }

    @Override
    public void showSnackBarMsg(@StringRes int msg) {

    }

    @Override
    public void showSnackBarMsg(String msg) {

    }
}
