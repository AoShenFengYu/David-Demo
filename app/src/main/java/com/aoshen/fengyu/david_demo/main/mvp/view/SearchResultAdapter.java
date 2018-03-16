package com.aoshen.fengyu.david_demo.main.mvp.view;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aoshen.fengyu.david_demo.R;
import com.aoshen.fengyu.david_demo.Tools;
import com.aoshen.fengyu.david_demo.main.mvp.model.bean.SearchResult;
import com.facebook.drawee.view.SimpleDraweeView;

import static android.content.ContentValues.TAG;

/**
 * Created by kika-david on 2018/3/15.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ItemViewHolder> {

    private final static float ITEM_HEIGHT = 0.25f;
    private Context mContext;
    private RecyclerView mList;
    private SearchResult mSearchResult;

    public SearchResultAdapter(Context context, RecyclerView list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View itemView;

        switch (viewType) {
            case ViewType.ITEM:
                itemView = layoutInflater.inflate(R.layout.search_result_list_item, parent, false);
                break;

            default:
                itemView = layoutInflater.inflate(R.layout.empty_view, parent, false);
        }

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case ViewType.ITEM:
                SearchResult.ResultsBean data = mSearchResult.getResults().get(position);
                Uri picUri = Uri.parse(data.getArtworkUrl100());

                holder.trackName.setText(data.getTrackName());
                holder.thumb.setImageURI(picUri);
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (mSearchResult == null) {
            return 0;

        } else {
            return mSearchResult.getResults().size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return ViewType.ITEM;
    }

    public void update(SearchResult searchResult) {
        this.mSearchResult = searchResult;
        notifyItemRangeChanged(0, getItemCount());
    }

    class ViewType {
        public final static int ITEM = 3;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView thumb;
        TextView trackName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            setupView();
        }

        private void setupView() {
            int itemViewHeight = (int) (Tools.getScreenSize(mContext)[0] * ITEM_HEIGHT);

            itemView.getLayoutParams().height = itemViewHeight;

            thumb = itemView.findViewById(R.id.search_result_list_item_thumb);
            thumb.getLayoutParams().width = itemViewHeight;
            thumb.getLayoutParams().height = itemViewHeight;

            trackName = itemView.findViewById(R.id.search_result_list_item_track_name);
        }
    }
}
