package com.pingtop.android.views.activities;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.pingtop.android.R;
import com.pingtop.android.adapter.list.CityListAdapter;
import com.pingtop.android.base.BaseActivity;
import com.pingtop.android.base.BaseApplication;
import com.pingtop.android.injector.component.ActivityComponent;
import com.pingtop.android.injector.component.DaggerActivityComponent;
import com.pingtop.android.injector.module.ActivityModule;
import com.pingtop.android.interfaces.ICityChoiceView;
import com.pingtop.android.presenter.impl.CityChoicePresenter;

import javax.inject.Inject;

import butterknife.BindView;

public class CityChoiceActivity extends BaseActivity implements ICityChoiceView {

    @Inject
    CityChoicePresenter mCityChoicePresenter;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_city)
    RecyclerView mRvCity;
    @BindView(R.id.pb_bg)
    ProgressBar mPbBg;


    @Override
    protected void initializePresenter() {
        mCityChoicePresenter.attachView(this);
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
        return R.layout.activity_city_choice;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRvCity.setLayoutManager(new LinearLayoutManager(this));
        mCityChoicePresenter.onCreate(savedInstanceState);
    }

    @Override
    public void showSnackBarMsg(@StringRes int msg) {

    }

    @Override
    public void showSnackBarMsg(String msg) {

    }

    @Override
    public void setAdapter(CityListAdapter cityListAdapter) {
        mRvCity.setAdapter(cityListAdapter);
    }

    @Override
    public void hideProgressBar() {
        mPbBg.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgressBar() {
        mPbBg.setVisibility(View.VISIBLE);
    }

    @Override
    public void refreshAdapter() {
        mRvCity.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void setToolBarTitle(String s) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(s);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}
