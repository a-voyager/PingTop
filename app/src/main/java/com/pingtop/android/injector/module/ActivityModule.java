package com.pingtop.android.injector.module;

import android.app.Activity;
import android.content.Context;

import com.pingtop.android.injector.scrope.ActivityScope;
import com.pingtop.android.injector.scrope.ContextLifeCycle;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wuhaojie on 2016/7/7 10:53.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity getActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    @ContextLifeCycle("Activity")
    public Context getContext() {
        return mActivity;
    }
}
