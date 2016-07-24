package com.pingtop.android.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.pingtop.android.R;
import com.pingtop.android.adapter.MainPaggerAdapter;
import com.pingtop.android.base.IView;
import com.pingtop.android.entities.PageItem;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.IMainView;
import com.pingtop.android.manager.PageDataFactory;
import com.pingtop.android.manager.UserInfoManager;
import com.pingtop.android.presenter.IPresenter;
import com.pingtop.android.views.activities.CityChoiceActivity;
import com.pingtop.android.views.activities.LoginActivity;
import com.pingtop.android.views.activities.MainActivity;

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
        mIMainView.setPagerAdapter(mainPaggerAdapter);
    }

    public void clickAvatar(View v) {
        // TODO: 2016/7/21 判断是否登录 并处理点击头像请求
//        mIMainView.showSnackBarMsg("测试");
        if (UserInfoManager.isLogined()) {

        } else {
            Intent intent = new Intent(mContext, LoginActivity.class);
            mContext.startActivity(intent);
        }
    }

    public void clickZoneMessage() {
        // TODO: 2016/7/21 判断是否登录 跳转到消息中心
        mIMainView.showSnackBarMsg("消息中心");
    }

    public void clickZoneRoute() {
        mIMainView.showSnackBarMsg("路径");

    }

    public void clickZoneFavorite() {
        mIMainView.showSnackBarMsg("收藏");

    }


    public void onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_city:
                Intent intent = new Intent(mContext, CityChoiceActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.action_search:
                break;
        }
    }
}
