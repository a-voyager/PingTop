package com.pingtop.android.presenter.impl;

import android.content.Context;
import android.os.Bundle;

import com.pingtop.android.base.IView;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.IMainView;
import com.pingtop.android.presenter.IPresenter;

import javax.inject.Inject;


/**
 * Created by wuhaojie on 2016/7/7 11:28.
 */
public class MainPresenter implements IPresenter {

    private Context mContext;
    private IMainView mIMainView;
    private boolean isFirst = true;

    @Inject
    public MainPresenter(@ContextLifeCycle("Activity") Context context) {
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

    }
}
