package com.wj.wjnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by wj on 17-12-16.
 */

public abstract class RecyclerViewBaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<T> mData;
    private Context mContext;

    public RecyclerViewBaseAdapter(Context mContext,List<T> mData) {
        this.mData = mData;
        this.mContext = mContext;
    }


    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }
}
