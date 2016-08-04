package com.pingtop.android.views.activities;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.MenuItem;
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
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.settings);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mLvSettings.setAdapter(new SettingsListAdapter(this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showSnackBarMsg(@StringRes int msg) {

    }

    @Override
    public void showSnackBarMsg(String msg) {

    }

}
