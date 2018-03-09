package com.aoshen.fengyu.david_demo;

import android.util.Log;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.aoshen.fengyu.david_demo.Constant.TAG;

/**
 * Created by kika-david on 2018/3/6.
 */

public class Presenter {

    private Model model;

    @Inject
    public Presenter(Model model) {
        this.model = model;
        model.setPresenter(this);
    }

    public void startWorking() {
        model.getSearchResult("Despacito", new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                SearchResult searchResult = response.body();
                Log.e(TAG, "onResponse " +response.toString());
                Log.e(TAG, "onResponse " +response.message());
                Log.e(TAG, "onResponse " +response.isSuccessful());
                Log.e(TAG, "onResponse " + searchResult.toString());
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.e(TAG, "onFailure ");
            }
        });
    }
}
