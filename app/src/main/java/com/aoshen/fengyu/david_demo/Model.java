package com.aoshen.fengyu.david_demo;

import android.util.Log;

import javax.inject.Inject;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by kika-david on 2018/3/6.
 */

public class Model {

    private final static String URL_PROTOCOL = "https://";
    private final static String URL_HOST_NAME = "api.dribbble.com";
    private final static String URL_PATH_V2_USER = "/v2/user";
    private final static String URL_PATH_V2_LIST_SHOTS = "/v2/user/shots";

    class UrlType {
        final static int LIST_SHOTS = 1;
    }

    private Presenter presenter;
    private OkHttpClient okHttpClient;

    public Model(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void getListShot(Callback callback) {
        Request request = new Request.Builder()
                .url(getUrl(UrlType.LIST_SHOTS))
    }

    private String getUrl(int type) {
        String result = URL_PROTOCOL + URL_HOST_NAME;

        switch (type) {
            case UrlType.LIST_SHOTS:
                result += URL_PATH_V2_LIST_SHOTS;

            default:
                result += URL_PATH_V2_LIST_SHOTS;
        }

        return result;
    }
}
