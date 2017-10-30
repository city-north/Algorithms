package com.eric.queue;

import com.eric.stdIn.StdIn;
import com.eric.stdOut.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 数组队列
 * 能够动态调整数组的大小的实现
 * @author Chen 2017/10/20
 */
public class ResizingArrayQueue<T> implements Iterable<T> {
    private T[] q;      //队列中的元素
    private int count;  //队列中元素的个数
    private int first;  //队列中第一个元素的索引
    private int last;   //队列中下一个可以获取的索引

    public ResizingArrayQueue(){
        q = (T[]) new Object[2];
        count = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int zize(){
        return count;
    }

    /**
     * 根据输入的大小调整数组长度
     */
    private void resize(int capacity){
        if(capacity < count){
            throw new RuntimeException();
        }
        T[] temp = (T[]) new Object[capacity];
        for(int i=0;i<count;i++){
            temp[i] =q[(first +i)%q.length];
        }
        q = temp;
        first = 0;
        last = count;
    }

    /**
     * 入队
     */
    public void enqueue(T item) {
        if (count == q.length) resize(2*q.length);
        q[last++] = item;
        if (last == q.length) last = 0;
        count++;
    }

    public int size() {
        return count;
    }

    /**
     * 出队
     */
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        T item = q[first];
        q[first] = null;
        count--;
        first++;
        if (first == q.length) first = 0;
        if (count > 0 && count == q.length/4) resize(q.length/2);
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[first];
    }
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int i = 0;
        public boolean hasNext()  { return i < count; }
        public void remove()      { throw new UnsupportedOperationException();  }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }


}
