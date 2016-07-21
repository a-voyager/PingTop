package com.pingtop.android.views.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.pingtop.android.R;
import com.pingtop.android.base.BaseActivity;
import com.pingtop.android.base.BaseApplication;
import com.pingtop.android.injector.component.ActivityComponent;
import com.pingtop.android.injector.component.DaggerActivityComponent;
import com.pingtop.android.injector.module.ActivityModule;
import com.pingtop.android.interfaces.ILoginView;
import com.pingtop.android.presenter.impl.LoginPresenter;
import com.pingtop.android.utils.SnackBarUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

    @Inject
    LoginPresenter mLoginPresenter;
    @BindView(R.id.et_user_name)
    AutoCompleteTextView mUserName;
    @BindView(R.id.et_password)
    EditText mPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.ll_login)
    LinearLayout mLlLogin;
    private ProgressDialog mProgressDialog;

    @OnClick(R.id.btn_login)
    void clickLogin(View view) {
        mLoginPresenter.clickLogin();
    }

    @Override
    protected void initializePresenter() {
        mLoginPresenter.attachView(this);
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
        return R.layout.activity_login;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("提示");
        mProgressDialog.setMessage("请稍候");
        mProgressDialog.setCancelable(false);
    }

    @Override
    public void showSnackBarMsg(@StringRes int msg) {
        SnackBarUtils.show(mLlLogin, msg);
    }

    @Override
    public void showSnackBarMsg(String msg) {
        SnackBarUtils.show(mLlLogin, msg);
    }

    @Override
    public void dismissDialog() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showDialog() {
        mProgressDialog.show();
    }
}