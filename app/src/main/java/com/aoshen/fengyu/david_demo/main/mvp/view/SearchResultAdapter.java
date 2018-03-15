package com.aoshen.fengyu.david_demo.main.mvp.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kika-david on 2018/3/15.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ItemViewHolder> {

    private Context mContext;
    private RecyclerView mList;

    public SearchResultAdapter(Context context, RecyclerView list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        int viewType;

        public ItemViewHolder(View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;
        }
    }
}
