package com.aoshen.fengyu.david_demo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kika-david on 2018/3/6.
 */

@Module
public class AppModule {

    @Singleton
    @Provides
    Presenter providePresenter() {
        return new Presenter(provideModel());
    }

    @Singleton
    @Provides
    Model provideModel() {
        return new Model();
    }
}
