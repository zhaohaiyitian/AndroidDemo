package com.wj.wjnews.ui.activity.designpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.wj.wjnews.R;
import com.wj.wjnews.framework.ViewUtils;
import com.wj.wjnews.framework.ioc.CheckNet;
import com.wj.wjnews.framework.ioc.OnClick;
import com.wj.wjnews.framework.ioc.ViewById;
import com.wj.wjnews.ui.activity.designpattern.singleton.SingletonManager;

public class DesignPatternActivity extends AppCompatActivity {

    @ViewById(R.id.singleton)
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_pattern);
        initView();
        ViewUtils.inject(this);
    }

    private void initView() {

    }

    @OnClick(R.id.singleton)
    @CheckNet
    private void onClick() {
        Toast.makeText(this, "onClick", Toast.LENGTH_SHORT).show();
    }

    /**
     * 单例
     */
    private void Single() {
        SingletonManager innerInstance = SingletonManager.getInnerInstance();
        SingletonManager instance = SingletonManager.getInstance();
        SingletonManager.SingleTon singleTon = SingletonManager.SingleTon.INSTANCE;
    }

}
