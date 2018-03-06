package com.aoshen.fengyu.david_demo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kika-david on 2018/3/6.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity activity);
}
