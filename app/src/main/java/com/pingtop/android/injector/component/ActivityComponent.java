package com.pingtop.android.injector.component;


import android.app.Activity;
import android.content.Context;

import com.pingtop.android.views.activities.MainActivity;
import com.pingtop.android.injector.module.ActivityModule;
import com.pingtop.android.injector.scrope.ActivityScope;
import com.pingtop.android.injector.scrope.ContextLifeCycle;

import dagger.Component;

/**
 * Created by wuhaojie on 2016/7/7 10:57.
 */
@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    Activity activity();

    @ContextLifeCycle("Activity")
    Context activityContext();

    @ContextLifeCycle("App")
    Context appContext();


}
