package com.wj.wjnews.ui.activity.designpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wj.wjnews.R;
import com.wj.wjnews.ui.activity.designpattern.singleton.SingletonManager;

public class DesignPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.singleton);
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
