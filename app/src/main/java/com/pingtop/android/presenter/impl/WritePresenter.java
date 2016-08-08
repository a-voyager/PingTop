package com.pingtop.android.presenter.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.pingtop.android.R;
import com.pingtop.android.base.IView;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.IWriteView;
import com.pingtop.android.presenter.IPresenter;

import java.util.List;

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

    public void onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ((Activity) mContext).finish();
                break;
            case R.id.action_submit:
                submitMessage();
                break;
        }
    }

    private void submitMessage() {
        mIWriteView.hideKeyboard();

        // 判断是否填写内容
        if (!mIWriteView.checkNotNull()) return;

        boolean qq = mIWriteView.isQQChecked();
        boolean weixin = mIWriteView.isWeiXinChecked();
        boolean weibo = mIWriteView.isWeiBoChecked();

        String location = mIWriteView.getLocation();

        String text = mIWriteView.getMessageText();

        List<String> path = mIWriteView.getImagesFilePaths();

        mIWriteView.showSnackBarMsg("content = " + text
                + ": " + qq + " " + weixin + " " + weibo);

//        ((Activity)mContext).finish();

    }
}
