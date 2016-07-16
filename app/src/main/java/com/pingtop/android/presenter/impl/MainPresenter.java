package com.pingtop.android.presenter.impl;

import android.content.Context;
import android.os.Bundle;

import com.pingtop.android.views.activities.MainActivity;
import com.pingtop.android.adapter.MainPaggerAdapter;
import com.pingtop.android.base.IView;
import com.pingtop.android.entities.PageItem;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.IMainView;
import com.pingtop.android.manager.PageDataFactory;
import com.pingtop.android.presenter.IPresenter;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by wuhaojie on 2016/7/7 11:28.
 */
public class MainPresenter implements IPresenter {

    private Context mContext;
    private IMainView mIMainView;

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
        mIMainView = (IMainView) v;
    }

    public void initPageData() {
        List<PageItem> pageItems = PageDataFactory.createPages(mContext);
        MainPaggerAdapter mainPaggerAdapter = new MainPaggerAdapter(((MainActivity) mContext).getSupportFragmentManager(), pageItems);
        mIMainView.setPaggerAdapter(mainPaggerAdapter);
    }

}
