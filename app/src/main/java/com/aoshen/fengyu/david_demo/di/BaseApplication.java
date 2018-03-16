package com.aoshen.fengyu.david_demo.di;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by kika-david on 2018/3/14.
 */

public class BaseApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.create().inject(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        Fresco.initialize(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mDispatchingAndroidInjector;
    }

}
