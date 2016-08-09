package com.pingtop.android.views.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.pingtop.android.R;
import com.pingtop.android.adapter.grid.WriteGirdImgAdapter;
import com.pingtop.android.base.BaseActivity;
import com.pingtop.android.base.BaseApplication;
import com.pingtop.android.injector.component.ActivityComponent;
import com.pingtop.android.injector.component.DaggerActivityComponent;
import com.pingtop.android.injector.module.ActivityModule;
import com.pingtop.android.interfaces.IWriteView;
import com.pingtop.android.presenter.impl.WritePresenter;
import com.pingtop.android.utils.SnackBarUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class WriteMessageActivity extends BaseActivity implements IWriteView {

    @Inject
    WritePresenter mWritePresenter;
    @BindView(R.id.cb_qq)
    CheckBox mCbQq;
    @BindView(R.id.cb_weixin)
    CheckBox mCbWeixin;
    @BindView(R.id.cb_weibo)
    CheckBox mCbWeibo;
    @BindView(R.id.content_text)
    EditText mContentText;
    @BindView(R.id.gv_img)
    GridView mGvImg;
    @BindView(R.id.ll_write)
    LinearLayout mLlWrite;
    private InputMethodManager mImm;
    private WriteGirdImgAdapter mWriteGirdImgAdapter;

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
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mWritePresenter.onCreate(savedInstanceState);
        mWriteGirdImgAdapter = new WriteGirdImgAdapter(this);
        mGvImg.setAdapter(mWriteGirdImgAdapter);
        mGvImg.setOnItemClickListener((adapterView, view, i, l) -> mWritePresenter.onItemClick(adapterView, view, i, l));
    }

    @Override
    public void showSnackBarMsg(@StringRes int msg) {
        SnackBarUtils.show(mLlWrite, msg);
    }

    @Override
    public void showSnackBarMsg(String msg) {
        SnackBarUtils.show(mLlWrite, msg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_write, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mWritePresenter.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean isQQChecked() {
        return mCbQq.isChecked();
    }

    @Override
    public boolean isWeiXinChecked() {
        return mCbWeixin.isChecked();
    }

    @Override
    public boolean isWeiBoChecked() {
        return mCbWeibo.isChecked();
    }

    @Override
    public String getLocation() {
        // TODO: 2016/8/8 获取旅行地
        return "";
    }

    @Override
    public String getMessageText() {
        String s = mContentText.getText().toString().trim();
        return s;
    }

    @Override
    public List<String> getImagesFilePaths() {
        return null;
    }

    @Override
    public boolean checkNotNull() {
        String s = mContentText.getText().toString().trim();
        if (TextUtils.isEmpty(s)) {
            showSnackBarMsg("填写好内容后才能发表哦~");
            return false;
        }
        return true;
    }

    @Override
    public void hideKeyboard() {
        if (mImm == null)
            mImm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mImm.hideSoftInputFromWindow(mContentText.getWindowToken(), 0);
    }

    @Override
    public int getImageListSize() {
        return mWriteGirdImgAdapter == null ? 0 : mWriteGirdImgAdapter.getListSize();
    }

}
