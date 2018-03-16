package com.aoshen.fengyu.david_demo.main.mvp.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.aoshen.fengyu.david_demo.main.mvp.MainContract;
import com.aoshen.fengyu.david_demo.main.mvp.model.MainModel;
import com.aoshen.fengyu.david_demo.main.mvp.model.bean.SearchResult;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.aoshen.fengyu.david_demo.Constant.TAG;

/**
 * Created by kika-david on 2018/3/6.
 */

public class MainPresenter implements MainContract.Presenter, ToMainActivityViewAdapter{

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
    }

    @Override
    public void search(String keyword) {
        Logger.d("搜尋, Keyword = "+keyword);

        if(!TextUtils.isEmpty(keyword)){
            mMainModel.getSearchResult(keyword, new Callback<SearchResult>() {
                @Override
                public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                    SearchResult searchResult = response.body();

                    Logger.d("搜尋, onResponse, searchResult = " + searchResult.toString());
                    mView.updateSearchResultList(searchResult);
                }

                @Override
                public void onFailure(Call<SearchResult> call, Throwable t) {
                    Logger.e("搜尋, onFailure");
                }
            });
        }
    }
}
