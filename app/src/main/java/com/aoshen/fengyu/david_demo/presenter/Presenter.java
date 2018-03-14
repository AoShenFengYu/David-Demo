package com.aoshen.fengyu.david_demo.presenter;

import android.util.Log;

import com.aoshen.fengyu.david_demo.model.Model;
import com.aoshen.fengyu.david_demo.model.SearchResult;
import com.aoshen.fengyu.david_demo.view.IView;
import com.aoshen.fengyu.david_demo.view.View;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.aoshen.fengyu.david_demo.Constant.TAG;

/**
 * Created by kika-david on 2018/3/6.
 */

public class Presenter implements IPresenter {

    private Model model;
    private IView view;

    @Inject
    public Presenter(Model model, IView view) {
        this.model = model;
        this.view = view;
        model.setPresenter(this);
        view.setPresenter(this);
    }

    public void startWorking() {
        model.getSearchResult("Despacito", new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                SearchResult searchResult = response.body();
                Log.e(TAG, "onResponse " + response.toString());
                Log.e(TAG, "onResponse " + response.message());
                Log.e(TAG, "onResponse " + response.isSuccessful());
                Log.e(TAG, "onResponse " + searchResult.toString());
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.e(TAG, "onFailure ");
            }
        });
    }
}
