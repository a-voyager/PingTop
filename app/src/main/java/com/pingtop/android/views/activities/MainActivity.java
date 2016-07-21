package com.pingtop.android.views.activities;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.pingtop.android.R;
import com.pingtop.android.adapter.MainPaggerAdapter;
import com.pingtop.android.base.BaseActivity;
import com.pingtop.android.base.BaseApplication;
import com.pingtop.android.injector.component.ActivityComponent;
import com.pingtop.android.injector.component.DaggerActivityComponent;
import com.pingtop.android.injector.module.ActivityModule;
import com.pingtop.android.interfaces.IMainView;
import com.pingtop.android.presenter.impl.MainPresenter;
import com.pingtop.android.utils.SnackBarUtils;
import com.pingtop.android.views.fragments.main.ZoneFragment;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements IMainView, ZoneFragment.OnFragmentInteractionListener {

    @Inject
    MainPresenter mMainPresenter;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.tab_main)
    TabLayout mTabMain;
    @BindView(R.id.cl_main)
    CoordinatorLayout mClMain;


    @Override
    protected void initializePresenter() {
        mMainPresenter.attachView(this);
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
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mMainPresenter.initPageData();
        mTabMain.setupWithViewPager(mViewPager);
    }

    @Override
    public void showSnackBarMsg(@StringRes int msg) {
        SnackBarUtils.show(mClMain, msg);
    }

    @Override
    public void showSnackBarMsg(String msg) {
        SnackBarUtils.show(mClMain, msg);
    }

    @Override
    public void setPagerAdapter(MainPaggerAdapter mainPaggerAdapter) {
        mViewPager.setAdapter(mainPaggerAdapter);
    }

    /**
     * 点击头像登录
     *
     * @param v LinearLayout
     */
    @Override
    public void clickZoneAvatar(View v) {
        mMainPresenter.clickAvatar(v);
    }

    @Override
    public void clickZoneFavorite() {
        mMainPresenter.clickZoneFavorite();
    }

    @Override
    public void clickZoneRoute() {
        mMainPresenter.clickZoneRoute();
    }

    @Override
    public void clickZoneMessage() {
        mMainPresenter.clickZoneMessage();
    }

}
