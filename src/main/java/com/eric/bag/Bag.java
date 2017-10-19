package com.eric.bag;

import com.eric.stdOut.StdOut;
import com.eric.stdIn.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 背包（元素处理的顺序并不重要）
 * @author Chen 2017/10/17
 */
public class Bag<T> implements Iterable<T> {
    private Node<T> first;    // 背包的开始元素
    private int n;               // 背包内有多少个元素

    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    /**
     * 初始化一个空的背包
     */
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * 判断背包是否为空
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 查询背包中有多少个元素
     */
    public int size() {
        return n;
    }

    /**
     * 往背包中添加一个元素
     */
    public void add(T item) {
        //现将附初始化元素放入一个容器
        Node<T> oldfirst = first;
//        新建一个节点
        first = new Node<T>();
        first.item = item;
//        简历顺序关系
        first.next = oldfirst;
        n++;
    }


    /**
     * 返回一个迭代器
     */
    public Iterator<T> iterator()  {
        return new ListIterator<T>(first);
    }

    // 一个迭代器，没有实现remove方法，因为背包不支持从中删除元素的集合数据结构
    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext(){
            return current != null;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }

        public T next(){
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Unit tests the {@code Bag} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(item.equals("!END")){
                break;
            }
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) {
            StdOut.println(s);
        }
    }

}
