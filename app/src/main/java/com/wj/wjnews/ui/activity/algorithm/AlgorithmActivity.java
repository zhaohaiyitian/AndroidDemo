package com.wj.wjnews.ui.activity.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wj.wjnews.R;

/**
 * 主要包含 排序 栈(用数组实现) 二叉树
 */
public class AlgorithmActivity extends AppCompatActivity implements View.OnClickListener {
    int[] number={6,4,9,2,5,8,7};
    private TextView numberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm);
        initView();
    }

    private void initView() {
         numberView = (TextView) findViewById(R.id.number2);
         findViewById(R.id.maopao).setOnClickListener(this);
         findViewById(R.id.charu).setOnClickListener(this);
         findViewById(R.id.xuanze).setOnClickListener(this);
         findViewById(R.id.kauisu).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.maopao:
                BubbleSort();
                break;
            case R.id.charu:
                InsertSort();
                break;
            case R.id.kauisu:
                RapidSort();
                break;
            case R.id.xuanze:
                SelectSort();
                break;

        }

    }

    /**
     * 冒泡排序
     * 描述：
     * 外层循环控制排序趟数
     * 内层循环控制每一趟排序多少次
     */
    private void BubbleSort() {
        for (int i = 0; i < number.length-1; i++) {
            for (int j = 0; j < number.length-1-i; j++) {
                if (number[j]>number[j+1]) {
                    int temp=number[j];
                    number[j]=number[j+1];
                    number[j+1]=temp;
                }
            }
        }
        showNumber();
    }
    /**
     * 插入排序
     */
    private void InsertSort() {

    }
    /**
     * 快速排序
     */
    private void RapidSort() {

    }

    /**
     * 选择排序
     */
    private void SelectSort() {

    }

    private void showNumber() {
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            builder.append(number[i]).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        numberView.setText("排序后: "+builder);
    }

}
