package com.wj.wjnews.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wj.wjnews.R;
import com.wj.wjnews.view.dialog.PromptDialog;

/**
 * Created by wj on 17-12-14.
 */

public class MineFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_mine,container,false);
        return rootView;
    }

    private void showDialog() {

    }
}
