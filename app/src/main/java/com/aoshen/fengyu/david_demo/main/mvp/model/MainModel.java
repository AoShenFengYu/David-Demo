package com.aoshen.fengyu.david_demo.main.mvp.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.aoshen.fengyu.david_demo.main.mvp.model.bean.SearchResult;
import com.aoshen.fengyu.david_demo.main.mvp.model.retrofit.ITunesService;
import com.aoshen.fengyu.david_demo.main.mvp.presenter.ToMainActivityViewAdapter;
import com.aoshen.fengyu.david_demo.main.mvp.presenter.MainPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import static com.aoshen.fengyu.david_demo.Constant.COUNTRY_CODE;

/**
 * Created by kika-david on 2018/3/6.
 */

public class MainModel extends BaseModel{

    private MainPresenter mMainPresenter;
    private ToMainActivityViewAdapter mMainActivityViewAdapter;
    private Retrofit mRetrofit;

    /**
     * Data
     * **/
//    private

    public MainModel(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }

    public void setPresenter(MainPresenter mainPresenter, ToMainActivityViewAdapter mainActivityViewAdapter) {
        this.mMainPresenter = mainPresenter;
        this.mMainActivityViewAdapter = mainActivityViewAdapter;
    }

    public void getSearchResult(String keyword, Callback<SearchResult> callback) {
        ITunesService service = mRetrofit.create(ITunesService.class);
        Call<SearchResult> call = service.getSearchResult(keyword, COUNTRY_CODE);

        call.enqueue(callback);
    }

}
