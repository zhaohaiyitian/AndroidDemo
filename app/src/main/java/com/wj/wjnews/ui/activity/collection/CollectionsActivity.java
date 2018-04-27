package com.wj.wjnews.ui.activity.collection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wj.wjnews.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * HashMap,TreeMap,LinkedHashMap, HashTable
 *
 * LinkedList, ArrayList
 *
 * TreeSet, HashSet
 */
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
     * 不能保证元素的顺序
     * HashMap 线程不安全(非同步) 允许null值null键 key不允许重复(如果重复会替换之前的元素(不会覆盖))
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
     * 元素有序
     *TreeMap的实现就是一个红黑树
     * 根据键进行排序(升序)
     */
    private void treeMap() {
        TreeMap<Integer,String> treeMap=new TreeMap<>();
        treeMap.put(0,"q");
        treeMap.put(1,"w");
        treeMap.put(2,"e");
        treeMap.put(3,"r");
        Log.d(TAG,treeMap.toString());
    }

    /**
     *基于Dictionary类 支持Iterator和Enumeration两种遍历方式
     * 线程安全 key,value都不可以为null
     */
    private void hashTable() {
        Hashtable<Integer,String> hashtable=new Hashtable<>();
        hashtable.put(0,"q");
        hashtable.put(1,"w");
        hashtable.put(2,"e");
        hashtable.put(3,"r");
        Log.d(TAG,hashtable.toString());
    }

    /**
     * 初始默认大小10 扩容时，扩容一半,如果扩容一半不够，就用目标的size作为扩容后的容量。
     * 动态数组实现,随机访问效率高，随机插入，删除效率底
     * 一般用在列表展示中
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
     * LinkedList线程不安全，允许元素为null的双向链表
     */
    private void linkedList() {
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("q");
        linkedList.add("w");
        linkedList.add("e");
        linkedList.add("r");
        Log.d(TAG,linkedList.toString());
    }

    /**
     *不能保证元素的迭代顺序
     *不包含重复元素,最多有一个null元素
     * HashSet实现Set接口
     * 底层使用HashMap来保存HashSet中的所有元素
     * 元素去重
     */
    private void hashSet() {
        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("q");
        hashSet.add("w");
        hashSet.add("e");
        hashSet.add("r");
        Log.d(TAG,hashSet.toString());
    }


    /**
     *TreeSet实现了SortedSet接口
     *TreeSet可以确保集合元素处于排序状态(升序)
     * 元素去重
     */
    private void treeSet() {
        TreeSet<String> treeSet=new TreeSet<>();
        treeSet.add("q");
        treeSet.add("w");
        treeSet.add("e");
        treeSet.add("r");
        Log.d(TAG,treeSet.toString());
    }
}
