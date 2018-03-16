package com.aoshen.fengyu.david_demo.main.mvp;

import com.aoshen.fengyu.david_demo.main.mvp.model.bean.SearchResult;

/**
 * Created by kika-david on 2018/3/14.
 */

public interface MainContract {

    interface View {
        void updateSearchResultList(SearchResult searchResult);
    }


    interface Presenter {
        void search(String keyword);
    }

}
