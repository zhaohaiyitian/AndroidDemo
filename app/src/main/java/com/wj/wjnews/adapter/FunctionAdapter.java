package com.wj.wjnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wj.wjnews.R;

import java.util.List;

/**
 * Created by wj on 18-4-15.
 */

public class FunctionAdapter extends RecyclerViewBaseAdapter<String> {
    public FunctionAdapter(Context mContext, List<String> mData) {
        super(mContext, mData);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.find_function_item,parent,false);
        return new FunctionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        String name = mData.get(position);
        TextView nameView= (TextView) holder.itemView.findViewById(R.id.function_txt);
        nameView.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener!=null) {
                    mOnItemClickListener.OnItemClick(position);
                }
            }
        });

    }

    class FunctionViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        public FunctionViewHolder(View itemView) {
            super(itemView);
            relativeLayout= (RelativeLayout) itemView;
        }
    }
    OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener {
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener=onItemClickListener;
    }
}
