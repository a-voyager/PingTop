package com.pingtop.android.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.pingtop.android.injector.component.AppComponent;
import com.pingtop.android.injector.component.DaggerAppComponent;
import com.pingtop.android.injector.interfaces.IConfigInjector;
import com.pingtop.android.injector.module.AppModule;


/**
 * Created by wuhaojie on 2016/7/7 10:28.
 */
public class BaseApplication extends Application implements IConfigInjector {


    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        Fresco.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
