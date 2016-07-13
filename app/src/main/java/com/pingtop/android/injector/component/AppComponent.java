package com.pingtop.android.injector.component;


import android.content.Context;

import com.pingtop.android.base.BaseApplication;
import com.pingtop.android.injector.module.AppModule;
import com.pingtop.android.injector.scrope.ContextLifeCycle;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wuhaojie on 2016/7/7 10:32.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    BaseApplication app();

    @ContextLifeCycle("App")
    Context context();

}
