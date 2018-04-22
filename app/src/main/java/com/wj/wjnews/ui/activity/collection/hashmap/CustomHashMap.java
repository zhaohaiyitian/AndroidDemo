package com.wj.wjnews.ui.activity.collection.hashmap;

/**
 * Created by wj on 18-4-20.
 * 手写HashMap实现
 */

public class CustomHashMap<K,V> implements Map<K,V>{
    private static int defaultLength=16;
    private static double loadFactor=0.75;
    private Entry[] table;
    private int size=0;

    public CustomHashMap(int length,double factor) {
        defaultLength=length;
        loadFactor=factor;
        table=new Entry[defaultLength];

    }

    public CustomHashMap() {
        this(defaultLength,loadFactor);
    }

    @Override
    public V put(K k, V v) {
        size++;
        int index = hash(k);
        Entry<K,V> entry=table[index];
        if (entry==null) {
            table[index]=newEntry(k,v,null);//传空是因为key不重复
        } else {
            newEntry(k,v,entry);
        }

        return (V) table[index].getValue();
    }

    public Entry<K,V> newEntry(K k,V v,Entry<K,V> next) {
        return new Entry<K,V>(k,v,next);
    }

    public int hash(K k) {
        int len=defaultLength;
        int index=k.hashCode()%len;
        return index>0?index:-index;
    }



    @Override
    public V get(K k) {
        int index = hash(k);
        if (table[index]==null) {
            return null;

        } else {
            return find(k,table[index]);
        }
    }

    private V find(K k, Entry entry) {
        if (k==entry.getKey()||k.equals(entry.getKey())) {
            return (V) entry.getValue();
        } else {
            if (entry.next!=null) {
                return find(k,entry.next);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }


    class Entry<K,V> implements Map.Entry<K,V> {
        K k;
        V v;
        Entry<K,V> next;
        public Entry(K k,V v,Entry<K,V> next) {
            this.k=k;
            this.v=v;
            this.next=next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
