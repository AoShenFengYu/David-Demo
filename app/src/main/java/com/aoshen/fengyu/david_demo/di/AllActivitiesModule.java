package com.aoshen.fengyu.david_demo.di;

import com.aoshen.fengyu.david_demo.main.mvp.view.MainActivity;
import com.aoshen.fengyu.david_demo.main.di.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by kika-david on 2018/3/15.
 */

@Module(subcomponents = {
        BaseActivityComponent.class
})
public abstract class AllActivitiesModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivitytInjector();

    // Add new Activity here
    // @ContributesAndroidInjector(modules = SecondActivityModule.class)
    // abstract SecondActivity contributeSecondActivityInjector();

}