package com.pingtop.android.views.activities;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.widget.ListView;

import com.pingtop.android.R;
import com.pingtop.android.adapter.list.SettingsListAdapter;
import com.pingtop.android.base.BaseActivity;

import butterknife.BindView;

public class SettingsActivity extends BaseActivity {


    @BindView(R.id.lv_settings)
    ListView mLvSettings;

    @Override
    protected void initializePresenter() {

    }

    @Override
    public void initializeInjector() {

    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_settings;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mLvSettings.setAdapter(new SettingsListAdapter(this));
    }

    @Override
    public void showSnackBarMsg(@StringRes int msg) {

    }

    @Override
    public void showSnackBarMsg(String msg) {

    }

}
