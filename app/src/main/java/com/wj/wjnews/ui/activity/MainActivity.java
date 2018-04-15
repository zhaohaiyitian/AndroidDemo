package com.wj.wjnews.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.wj.wjnews.R;
import com.wj.wjnews.ui.fragment.FindFragment;
import com.wj.wjnews.ui.fragment.HomeFragment;
import com.wj.wjnews.ui.fragment.MineFragment;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button home,find,mine;
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        initView();
        initFragments();
        switchContent(0);
    }



    private void initView() {
       home= (Button) findViewById(R.id.home);
       find= (Button) findViewById(R.id.find);
       mine= (Button) findViewById(R.id.mine);
       home.setOnClickListener(this);
       find.setOnClickListener(this);
       mine.setOnClickListener(this);
    }

    private void initFragments() {
        homeFragment = new HomeFragment();
        findFragment = new FindFragment();
        mineFragment = new MineFragment();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home:
                switchContent(0);
                break;
            case R.id.find:
                switchContent(1);
                break;
            case R.id.mine:
                switchContent(2);
                break;
        }
    }

    private void switchContent(int position) {
        hideAll();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                if (homeFragment==null) {
                    homeFragment=new HomeFragment();
                    transaction.add(R.id.content,homeFragment);
                } else {
                    if (!homeFragment.isAdded()) {
                        transaction.add(R.id.content,homeFragment).show(homeFragment);
                    } else {
                        transaction.show(homeFragment);
                    }
                }
                break;
            case 1:
                if (findFragment==null) {
                    findFragment=new FindFragment();
                    transaction.add(R.id.content,findFragment);
                } else {
                    if (!findFragment.isAdded()) {
                        transaction.add(R.id.content,findFragment).show(findFragment);
                    } else {
                        transaction.show(findFragment);
                    }
                }
                break;
            case 2:
                if (mineFragment==null) {
                    mineFragment=new MineFragment();
                    transaction.add(R.id.content,mineFragment);
                } else {
                    if (!mineFragment.isAdded()) {
                        transaction.add(R.id.content,mineFragment).show(mineFragment);
                    } else {
                        transaction.show(mineFragment);
                    }
                }
                break;
        }
        transaction.commit();
    }

    private void hideAll() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (homeFragment!=null) {
            transaction.hide(homeFragment);
        }
        if (findFragment!=null) {
            transaction.hide(findFragment);
        }
        if (mineFragment!=null) {
            transaction.hide(mineFragment);
        }
        transaction.commit();
    }

}
