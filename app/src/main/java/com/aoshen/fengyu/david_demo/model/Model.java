package com.aoshen.fengyu.david_demo.model;

import com.aoshen.fengyu.david_demo.presenter.Presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import static com.aoshen.fengyu.david_demo.Constant.COUNTRY_CODE;

/**
 * Created by kika-david on 2018/3/6.
 */

public class Model {

    private Presenter presenter;
    private Retrofit retrofit;

    public Model(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void getSearchResult(String keyword, Callback<SearchResult> callback) {
        ITunesService service = retrofit.create(ITunesService.class);
        Call<SearchResult> call = service.getSearchResult(keyword, COUNTRY_CODE);

        call.enqueue(callback);
    }
}
