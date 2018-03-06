package com.aoshen.fengyu.david_demo;

import android.util.Log;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * Created by kika-david on 2018/3/6.
 */

public class Model {

    Presenter presenter;

    private OkHttpClient okHttpClient;

    public Model(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
