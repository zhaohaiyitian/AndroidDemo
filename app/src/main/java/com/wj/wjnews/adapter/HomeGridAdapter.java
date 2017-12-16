package com.wj.wjnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.wj.wjnews.bean.HomeGridInfo;

import java.util.List;

/**
 * Created by wj on 17-12-16.
 */

public class HomeGridAdapter extends RecyclerViewBaseAdapter<HomeGridInfo>{

    public HomeGridAdapter(Context mContext, List<HomeGridInfo> mData) {
        super(mContext, mData);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
