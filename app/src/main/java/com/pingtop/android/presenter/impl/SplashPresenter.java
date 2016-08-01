package com.pingtop.android.presenter.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.pingtop.android.base.IView;
import com.pingtop.android.entities.response.RegisterResponse;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.ISplashView;
import com.pingtop.android.manager.DataManager;
import com.pingtop.android.presenter.IPresenter;
import com.pingtop.android.views.activities.MainActivity;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by wuhaojie on 2016/7/21 9:14.
 */
public class SplashPresenter implements IPresenter {
    public static final int DELAY_MILLIS = 2000;
    public static final String TAG = "SplashPresenter";
    private Context mContext;
    private ISplashView mSplashView;

    private static final int HANDLER_TO_MAIN_ACTIVITY = 0;


    @Inject
    public SplashPresenter(@ContextLifeCycle("Activity") Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mHandler.sendEmptyMessageDelayed(HANDLER_TO_MAIN_ACTIVITY, DELAY_MILLIS);
        checkToken();
    }

    private void checkToken() {
        boolean hasLoginInfo = DataManager.getPreferenceHelper(mContext).hasLoginInfo();
        if (!hasLoginInfo) {
            DataManager.getHttpHelper().getToken("test", new Subscriber<RegisterResponse>() {
                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable e) {
                    Log.e(TAG, e.toString());
                }

                @Override
                public void onNext(RegisterResponse registerResponse) {
                    if ("注册".equals(registerResponse.getTittle())) {
                        DataManager.getPreferenceHelper(mContext).saveToken(registerResponse.getExrInfo());
                    }
                    Log.d(TAG, registerResponse.toString());
                }
            });
        }
    }


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case HANDLER_TO_MAIN_ACTIVITY:
                    Intent intent = new Intent(mContext, MainActivity.class);
                    mContext.startActivity(intent);
                    ((Activity) mContext).finish();
                    break;
            }
        }
    };

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
        mSplashView = (ISplashView) v;
    }
}
