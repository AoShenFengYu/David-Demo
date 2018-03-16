package com.aoshen.fengyu.david_demo.main.mvp.view;

import android.support.design.widget.TextInputLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aoshen.fengyu.david_demo.R;
import com.aoshen.fengyu.david_demo.di.BaseActivity;
import com.aoshen.fengyu.david_demo.main.mvp.MainContract;
import com.aoshen.fengyu.david_demo.main.mvp.model.bean.SearchResult;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View , View.OnClickListener{

    @Inject
    MainContract.Presenter mPresenter;

    /**
     * View
     **/
    private TextInputLayout mSearchTextInputLayout;
    private EditText mSearchEditText;
    private Button mSearchButton;

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

        mSearchButton = findViewById(R.id.activity_main_search_button);
        mSearchButton.setOnClickListener(this);

        setupSearchResultList();
    }

    private void setupSearchResultList() {
        mSearchResultList = findViewById(R.id.activity_main_list);
        mSearchResultList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mSearchResultListAdapter = new SearchResultAdapter(this, mSearchResultList);
        mSearchResultList.setAdapter(mSearchResultListAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_main_search_button:
                searchKeyword();
                break;
        }
    }

    private void searchKeyword() {
        String keyword = mSearchEditText.getText().toString();

        mPresenter.search(keyword);
    }

    @Override
    public void updateSearchResultList(SearchResult searchResult) {
        mSearchResultListAdapter.update(searchResult);
    }
}
