package com.aoshen.fengyu.david_demo.di;

import com.aoshen.fengyu.david_demo.model.Model;
import com.aoshen.fengyu.david_demo.presenter.MainActivity;
import com.aoshen.fengyu.david_demo.presenter.Presenter;
import com.aoshen.fengyu.david_demo.view.View;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.aoshen.fengyu.david_demo.Constant.BASE_URL;
import static com.aoshen.fengyu.david_demo.Constant.DATE_FORMAT;

/**
 * Created by kika-david on 2018/3/6.
 */

@Module
public class AppModule {

    private MainActivity mainActivity;

    public AppModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Singleton
    @Provides
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Singleton
    @Provides
    Presenter providePresenter() {
        return new Presenter(provideModel(), provideView());
    }

    @Singleton
    @Provides
    Model provideModel() {
        return new Model(provideRetrofit());
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(provideGson()))
                .build();
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create();
    }

    @Singleton
    @Provides
    View provideView() {
        return new View(provideMainActivity());
    }
}
