package com.wj.wjnews.ui.activity.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wj.wjnews.R;

/**
 * 主要包含 排序 队列 栈(用数组实现) 线性表 链表 二叉树 图
 */
public class AlgorithmActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG="wangjie";
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
                int[] a={1,6,2,4,8,4};
                quickSort(a,0,a.length);
                break;
            case R.id.xuanze:
                SelectSort();
                break;

        }
    }

    /**
     * 冒泡排序
     * 原理：比较两个相邻的元素，将值大的元素交换到右端
     * 描述：
     * 外层循环控制排序趟数
     * 内层循环控制每一趟排序多少次
     * 时间复杂度 O(n^2) 两层for循环
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
     * 定义i=0，j=a.length-1，i为第一个数的下标，j为最后一个数下标
     * 从数组的最后一个数Aj从右往左找，找到第一小于key的数，记为Aj
     * 从数组的第一个数Ai 从左往右找，找到第一个大于key的数，记为Ai
     * 交换Ai 和Aj
     * 重复这个过程，直到 i=j
     * 调整key的位置，把A[i]和key交换
     */
    private void quickSort(int[] a,int low,int high) {
        //1,找到递归算法的出口
        if( low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[ low ];
        //4，完成一趟排序
        while( i< j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        quickSort(a, low, i-1 );
        //6, 对key右边的数快排
        quickSort(a, i+1, high);

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

    /**
     * 单向链表
     */
    private void onewayLinkedList() {
        OneWayLinkedList<String> list= new OneWayLinkedList<>();
        list.add("q");
        list.add("w");
        list.add("e");
        list.add("r");
    }
}
