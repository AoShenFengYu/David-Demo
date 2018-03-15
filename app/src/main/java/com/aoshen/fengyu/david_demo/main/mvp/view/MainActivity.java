package com.aoshen.fengyu.david_demo.main.mvp.view;

import android.support.design.widget.TextInputLayout;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.aoshen.fengyu.david_demo.R;
import com.aoshen.fengyu.david_demo.di.BaseActivity;
import com.aoshen.fengyu.david_demo.main.mvp.MainContract;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainContract.Presenter mPresenter;

    /**
     * View
     **/
    private TextInputLayout mSearchTextInputLayout;
    private EditText mSearchEditText;

    private RecyclerView mSearchResultList;
    private SearchResultAdapter mSearchResultListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }


    private void setupView() {
        mSearchTextInputLayout = findViewById(R.id.activity_main_text_input_layout);
        mSearchEditText = findViewById(R.id.activity_main_edit_text);
        setupSearchResultList();
    }

    private void setupSearchResultList() {
        mSearchResultList = findViewById(R.id.activity_main_list);
        mSearchResultListAdapter = new SearchResultAdapter(this, mSearchResultList);
        mSearchResultList.setAdapter(mSearchResultListAdapter);
    }
}
