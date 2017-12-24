package com.wj.wjnews.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;

import com.wj.wjnews.R;
import com.wj.wjnews.ui.fragment.FindFragment;
import com.wj.wjnews.ui.fragment.HomeFragment;
import com.wj.wjnews.ui.fragment.MineFragment;

public class MainActivity extends AppCompatActivity {

    String[] tabs={"Home","Find","Mine"};
    Class[] cls={HomeFragment.class, FindFragment.class, MineFragment.class};
    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        tabHost = (FragmentTabHost) findViewById(R.id.tabHost);
        tabHost.setup(this,getSupportFragmentManager(),R.id.content);
        tabHost.addTab(tabHost.newTabSpec(tabs[0]).setIndicator("首页"),cls[0],null);
        tabHost.addTab(tabHost.newTabSpec(tabs[1]).setIndicator("发现"),cls[1],null);
        tabHost.addTab(tabHost.newTabSpec(tabs[2]).setIndicator("我的"),cls[2],null);

    }
}
