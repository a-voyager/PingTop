package com.pingtop.android.views.activities;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.pingtop.android.R;
import com.pingtop.android.adapter.MainPaggerAdapter;
import com.pingtop.android.base.BaseActivity;
import com.pingtop.android.base.BaseApplication;
import com.pingtop.android.entities.global.UserEntity;
import com.pingtop.android.injector.component.ActivityComponent;
import com.pingtop.android.injector.component.DaggerActivityComponent;
import com.pingtop.android.injector.module.ActivityModule;
import com.pingtop.android.interfaces.IMainView;
import com.pingtop.android.presenter.impl.MainPresenter;
import com.pingtop.android.utils.SnackBarUtils;
import com.pingtop.android.views.fragments.main.ZoneFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
        EventBus.getDefault().register(this);
        mMainPresenter.onCreate(savedInstanceState);
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

    @Override
    protected void onStop() {
        super.onStop();
        mMainPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loginResult(UserEntity userEntity) {
        if (userEntity != null) {
            // TODO: 2016/7/21 登录成功
            showSnackBarMsg("main presenter get");
        } else {

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void changeCity(String newCityName) {
        showSnackBarMsg(newCityName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        SearchableInfo info = searchManager.getSearchableInfo(getComponentName());
        searchView.setSearchableInfo(info);

        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mMainPresenter.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        mMainPresenter.onNewIntent(intent);
    }
}
