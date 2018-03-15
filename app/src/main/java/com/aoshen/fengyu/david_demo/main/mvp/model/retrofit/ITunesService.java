package com.aoshen.fengyu.david_demo.main.mvp.model.retrofit;

import com.aoshen.fengyu.david_demo.main.mvp.model.bean.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.aoshen.fengyu.david_demo.Constant.PARAMETER_KEY_COUNTRY;
import static com.aoshen.fengyu.david_demo.Constant.PARAMETER_KEY_TERM;
import static com.aoshen.fengyu.david_demo.Constant.PATH_SEARCH;

/**
 * Created by kika-david on 2018/3/9.
 */

public interface ITunesService {
    @GET(PATH_SEARCH)
    Call<SearchResult> getSearchResult(@Query(PARAMETER_KEY_TERM) String keyword, @Query(PARAMETER_KEY_COUNTRY) String country);
}
