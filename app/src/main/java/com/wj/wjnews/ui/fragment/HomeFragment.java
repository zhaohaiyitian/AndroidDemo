package com.wj.wjnews.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wj.wjnews.R;
import com.wj.wjnews.adapter.MyPagerAdapter;

import java.util.ArrayList;

/**
 * Created by wj on 17-12-14.
 */

public class HomeFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private LinearLayout mPointContainer;
    ArrayList<Integer> mData = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private int mPosition;
    private RecyclerView gridLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=View.inflate(getActivity(), R.layout.fragment_home,null);
        initView(root);
        if (mData.size() > 0)
            mData.clear();
        initImg();
        mAdapter = new MyPagerAdapter(getContext(), mData);
        mViewPager.setAdapter(mAdapter);
        for (int i = 0; i < mData.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.drawable.selector_point_bg);
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(12,12);
            if (i!=0) {
                imageView.setEnabled(false);
                layoutParams.leftMargin=12;
            }
            imageView.setLayoutParams(layoutParams);
            mPointContainer.addView(imageView);
        }
//        mViewPager.setCurrentItem(0);
        handler.sendEmptyMessageDelayed(0,2000);

        return root;
    }


    private void initView(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mPointContainer = (LinearLayout) view.findViewById(R.id.pointContainer);
        gridLayout = (RecyclerView) view.findViewById(R.id.gridLayout);
        gridLayout.setLayoutManager(new GridLayoutManager(getContext(),4));
        mViewPager.addOnPageChangeListener(this);

    }

    void initImg() {
        mData.add(R.mipmap.screen);
        mData.add(R.mipmap.screen2);
        mData.add(R.mipmap.screen3);
        mData.add(R.mipmap.screen4);
        mData.add(R.mipmap.screen5);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ImageView childAt = (ImageView) mPointContainer.getChildAt(mPosition);
        childAt.setEnabled(false);
        mPosition=position;
        ImageView imageView = (ImageView) mPointContainer.getChildAt(position);
        imageView.setEnabled(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    int currentItem = mViewPager.getCurrentItem();
                    int pos=(currentItem+1)%mData.size();
                    mViewPager.setCurrentItem(pos);
                    handler.sendEmptyMessageDelayed(0,2000);
                    break;
            }
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
