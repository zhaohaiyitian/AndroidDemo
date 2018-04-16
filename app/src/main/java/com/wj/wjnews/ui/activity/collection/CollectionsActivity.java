package com.wj.wjnews.ui.activity.collection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wj.wjnews.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CollectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);
    }

    /**
     * HashMap 线程不安全 允许null值null键 key不允许重复 不能保证元素的顺序
     * 数组+链表实现(jdk1.8增加了红黑树)
     * initialCapacity(初始容量)=16 , loadFactor(负载因子)=0.75
     */
    private void HashMap() {
        HashMap<Integer,String> hashMap=new HashMap<>();
        hashMap.put(0,"q");
        hashMap.put(1,"w");
        hashMap.put(2,"e");
        hashMap.put(3,"r");
    }

    /**
     * LinkedHashMap是HashMap的子类 保证输出顺序和输入时的相同
     * LRU中就用到了LinkedHashMap集合
     */
    private void LinkedHashMap() {
        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<>();

    }

    private void arrayList() {
        ArrayList<String> list=new ArrayList<>();

    }

}
