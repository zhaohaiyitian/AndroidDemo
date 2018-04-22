package com.wj.wjnews.ui.activity.collection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wj.wjnews.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class CollectionsActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG="wangjie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);
        initView();
    }

    private void initView() {
        findViewById(R.id.hashmap).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hashmap:
                hashMap();
                break;
        }

    }

    /**
     * HashMap 线程不安全(非同步) 允许null值null键 key不允许重复(如果重复会替换之前的元素(不会覆盖)) 不能保证元素的顺序
     * 数组+链表实现(jdk1.8增加了红黑树)
     * initialCapacity(初始容量)=16 , loadFactor(负载因子)=0.75
     */
    private void hashMap() {
        HashMap<Integer,String> hashMap=new HashMap<>();
        hashMap.put(0,"q");
        hashMap.put(1,"w");
        hashMap.put(2,"e");
        String value = hashMap.put(3, "r");//如何key重复会返回老的值如果不重复会返回null
        Log.d(TAG,hashMap.toString());
    }

    /**
     * HashMap和双向链表合二为一就是LinkedHashMap
     * LinkedHashMap是HashMap的子类 保证输出顺序和输入时的相同
     * LRU中就用到了LinkedHashMap集合
     */
    private void linkedHashMap() {
        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put(0,"q");
        linkedHashMap.put(1,"w");
        linkedHashMap.put(2,"e");
        linkedHashMap.put(3,"r");
        Log.d(TAG,linkedHashMap.toString());
    }

    /**
     * 动态数组实现,随机访问效率高，随机插入，删除效率底
     * 非线程安全，多线程环境下可以考虑使用concurrent并发包下的CopyOnWriteArrayList类
     */
    private void arrayList() {
        ArrayList<String> list=new ArrayList<>();
        list.add("q");
        list.add("w");
        list.add("e");
        list.add("r");
        Log.d(TAG,list.toString());
    }

    /**
     * LinkedList是List接口的双向链表的实现
     * 随机插入，删除效率高  随机访问效率低
     */
    private void linkedList() {
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("q");
        linkedList.add("w");
        linkedList.add("e");
        linkedList.add("r");
        Log.d(TAG,linkedList.toString());
    }
}
