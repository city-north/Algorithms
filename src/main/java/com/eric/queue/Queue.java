package com.eric.queue;

import com.eric.stdIn.StdIn;
import com.eric.stdOut.StdOut;

import java.util.Iterator;

/**
 * 先进先出队列
 * @author Chen 2017/10/19
 */
public class Queue<T> implements Iterable<T>{
    private Node<T> first;  //队列第一个元素
    private Node<T> last;   //队列最后一个元素
    private int count;      //总元素数

    /**
     * 生成一个迭代器
     * 该迭代器用来遍历该FIFO(先进先出排序)队列的元素
     * @return
     */
    public Iterator<T> iterator() {
        return new ListIterator<T> (first);
    }

    /**
     * 初始化一个队列
     */
    public Queue(){
        first = null;
        last = null;
        count = 0;
    }

    /**
     * 返回是否为空
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * 返回队列的大小
     */
    public int size(){
        return count;
    }

    /**
     * 返回最近添加的元素
     */
    public T peek(){
        if(isEmpty()) throw new UnsupportedOperationException();
        return first.item;
    }

    /**
     * 向队列中添加一个新元素
     */
    public void enqueue(T item){
        Node<T> oldLast = last; //保存最后一个元素
        last = new Node<T>();   //创建一个新元素
        last.item = item;       //将形参中的新元素注入
        last.next = null;
        if(isEmpty()){//如果队列为空
            first = last;//最后一个就是第一个
        }else {
            oldLast.next = last;//新元素赋值给老元素的下一个
        }
        count++;
    }

    /**
     *出队列
     */
    public T dequeue(){
        if(isEmpty()) throw new UnsupportedOperationException("Queue underflow");
        T item = first.item;
        first = first.next;
        count--;
        if(isEmpty()) last = null;  //防止游离
        return item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**
     * 内部类
     * 迭代器类，用来生成队列的迭代器
     */
    private class ListIterator<T> implements Iterator<T>{
        private Node<T> current;        //当前节点

        /**
         * 构造初始化，将传入的节点作为当前节点
         */
        public ListIterator(Node<T> first) {
            this.current = first;
        }

        /**
         * 是否有下一个
         */
        public boolean hasNext(){
            return current !=null;
        }

        /**
         * 队列不支持删除
         */
        public void remove(){
            throw new UnsupportedOperationException();
        }

        /**
         * 获取下一个元素
         */
        public T next() {
            if(!hasNext()){
                throw new UnsupportedOperationException();
            }
            T item = current.item;  //传入的节点（第一个节点）
            current = current.next; //找到第一个节点的下一个节点
            return item;
        }
    }

    /**
     * 内部类
     * 节点类 用来连接各节点，表示节点间的关系
     * @param <T>
     */
    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(item.equals("!END")){
                System.out.println(queue.toString());
                break;
            }
            if (!item.equals("-"))
                queue.enqueue(item);
            else if (!queue.isEmpty())
                StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }

}
