package com.aoshen.fengyu.david_demo.di;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by kika-david on 2018/3/14.
 */

@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AllActivitiesModule.class
})
public interface ApplicationComponent {
    void inject(BaseApplication application);
}