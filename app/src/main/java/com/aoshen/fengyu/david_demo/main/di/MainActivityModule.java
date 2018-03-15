package com.aoshen.fengyu.david_demo.main.di;

import com.aoshen.fengyu.david_demo.main.mvp.view.MainActivity;
import com.aoshen.fengyu.david_demo.main.mvp.MainContract;
import com.aoshen.fengyu.david_demo.main.mvp.model.MainModel;
import com.aoshen.fengyu.david_demo.main.mvp.presenter.MainPresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.aoshen.fengyu.david_demo.Constant.BASE_URL;
import static com.aoshen.fengyu.david_demo.Constant.DATE_FORMAT;

/**
 * Created by kika-david on 2018/3/15.
 */

@Module
public class MainActivityModule {

    @Provides
    MainContract.Presenter providePresenter(MainActivity mainActivity) {
        return new MainPresenter(provideModel(), mainActivity);
    }

    @Provides
    MainModel provideModel() {
        return new MainModel(provideRetrofit());
    }

    @Provides
    MainContract.View provideMainActivity() {
        return null;
    }

    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(provideGson()))
                .build();
    }

    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create();
    }
}