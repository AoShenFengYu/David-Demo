package com.aoshen.fengyu.david_demo.main.mvp.presenter;

import android.util.Log;
import com.aoshen.fengyu.david_demo.main.mvp.MainContract;
import com.aoshen.fengyu.david_demo.main.mvp.model.MainModel;
import com.aoshen.fengyu.david_demo.main.mvp.model.bean.SearchResult;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.aoshen.fengyu.david_demo.Constant.TAG;

/**
 * Created by kika-david on 2018/3/6.
 */

public class MainPresenter implements MainContract.Presenter, ToMainActivityViewAdapter {

    /**
     * MainModel
     **/
    private MainModel mMainModel;

    /**
     * MainView
     **/
    private MainContract.View mView;

    @Inject
    public MainPresenter(MainModel mainModel, MainContract.View view) {
        this.mMainModel = mainModel;
        this.mView = view;
        mainModel.setPresenter(this, this);

        startWorking();
    }

    public void startWorking() {
        mMainModel.getSearchResult("Despacito", new Callback<SearchResult>() {
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
