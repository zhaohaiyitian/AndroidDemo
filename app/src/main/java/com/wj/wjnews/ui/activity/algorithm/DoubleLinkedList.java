package com.wj.wjnews.ui.activity.algorithm;

/**
 * Created by wj on 18-4-17.
 * 双向循环链表实现
 */

public class DoubleLinkedList<E> {

    private class Node<E> {
        public E value;
        public Node<E> preNode;
        public Node<E> nextNode;
        public Node(E value,Node<E> preNode,Node<E> nextNode) {
            this.value=value;
            this.preNode=preNode;
            this.nextNode=nextNode;
        }
    }

    private int size;
    private Node<E> head;
    public DoubleLinkedList() {
        Node<E> node=new Node<E>(null,null,null);
        head.preNode=head.nextNode=head;
        size=0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void validateIndex(int index) {
        if (index<0||index>size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<E> getNode(int index) {
        validateIndex(index);

        return null;
    }

    public E get(int index) {
        return getNode(index).value;
    }
}
