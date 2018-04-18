package com.wj.wjnews.ui.activity.algorithm;

/**
 * Created by wj on 18-4-17.
 * 单向链表实现
 */

public class OneWayLinkedList<E> {

    private class Node<E> {
        public E value;
        public Node<E> next;
        public Node(E value,Node<E> next) {
            this.value=value;
            this.next=next;
        }
    }

    private int size;
    public Node<E> head;
    public OneWayLinkedList() {
        head=new Node<E>(null,null);
        head.next=head;
        size=0;
    }

    public int size() {//链表大小
        return size;
    }

    public boolean isEmpty() {//链表是否为空
        return size==0;
    }

    public void validateIndex(int index) {
        if (index<0||index>size) {
            throw new IndexOutOfBoundsException();
        }
        return;
    }

    public void add(E value) {//在链表头部添加数据
        Node<E> node=new Node<E>(value,head.next);
        head.next=node;
        size++;
    }

    public void addLast(E value) {//在链表尾部添加数据
        Node<E> node=getNode(size-1);
        Node<E> lastNode=new Node<E>(value,null);
        node.next=lastNode;
        size++;
    }

    public Node<E> getNode(int index) {//获取节点
        validateIndex(index);
        Node<E> node=head.next;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }

    public E get(int index) {//获取节点的值
        return getNode(index).value;
    }

    public void insert(int index,E value) {//插入一个节点
        validateIndex(index);
        if (index==0) {
            add(value);
            return;
        }
        Node<E> preNode=getNode(index-1);
        Node<E> curNode=getNode(index);
        Node<E> node=new Node<E>(value,curNode);
        preNode.next=node;
        size++;
    }

    public void delete(int index) {//删除一个节点
        validateIndex(index);
        if (index==0) {
            head.next=head.next.next;
            size--;
            return;
        }
        Node<E> node=getNode(index-1);
        node.next=node.next.next;
        size--;
    }
}
