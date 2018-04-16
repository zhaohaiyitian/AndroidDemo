package com.wj.wjnews.ui.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wj.wjnews.R;
import com.wj.wjnews.adapter.FunctionAdapter;
import com.wj.wjnews.ui.activity.algorithm.AlgorithmActivity;
import com.wj.wjnews.ui.activity.collection.CollectionsActivity;
import com.wj.wjnews.ui.activity.designPattern.DesignPatternActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wj on 17-12-14.
 */

public class FindFragment extends BaseFragment {
    RecyclerView recyclerView;
    private List<String> nameList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_find,container,false);
        initData();
        initView(rootView);
        return rootView;
    }

    private void initData() {
        nameList.add("集合");
        nameList.add("设计模式");
        nameList.add("算法");
        nameList.add("NDK");
        nameList.add("自定义控件");
        nameList.add("三方图片框架");
        nameList.add("三方网络框架");
        nameList.add("三方注解框架");
        nameList.add("Material Design");
        nameList.add("三方分享");
        nameList.add("三方支付");
        nameList.add("三方登录");
        nameList.add("动画");
    }

    private void initView(View rootView) {
        recyclerView= (RecyclerView) rootView.findViewById(R.id.findList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new FunctionAdapter.SpaceItemDecpration(5));
        FunctionAdapter functionAdapter=new FunctionAdapter(getContext(),nameList);
        recyclerView.setAdapter(functionAdapter);
        functionAdapter.setOnItemClickListener(new FunctionAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                if (position==0) {
                    getActivity().startActivity(new Intent(getActivity(), CollectionsActivity.class));
                }else if (position==1) {
                    getActivity().startActivity(new Intent(getActivity(), DesignPatternActivity.class));
                }else if (position==2) {
                    getActivity().startActivity(new Intent(getActivity(), AlgorithmActivity.class));
                }

            }
        });
    }
}
