package com.pingtop.android.presenter.impl;

import android.content.Context;
import android.os.Bundle;

import com.pingtop.android.base.IView;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.IWriteView;
import com.pingtop.android.presenter.IPresenter;

import javax.inject.Inject;

/**
 * Created by wuhaojie on 2016/8/6 20:37.
 */
public class WritePresenter implements IPresenter {

    private Context mContext;
    private IWriteView mIWriteView;

    @Inject
    public WritePresenter(@ContextLifeCycle("Activity") Context context) {
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
        mIWriteView = (IWriteView) v;
    }
}
