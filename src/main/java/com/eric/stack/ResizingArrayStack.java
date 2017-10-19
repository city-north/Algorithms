package com.eric.stack;


import com.eric.stdIn.StdIn;
import com.eric.stdOut.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 下压栈（LOFO）
 * 能够动态调整数组的大小的实现
 * @author Chen 2017/10/19
 */
public class ResizingArrayStack<T> implements Iterable<T> {

    private T[] items; //栈元素
    private int count;                  //元素数量


    public ResizingArrayStack() {
        items = (T[]) new Object[1];
        count = 0;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 栈大小
     */
    public int size(){
        return count;
    }

    /**
     * 压栈
     */
    public void push(T item){
        //扩容两倍
        if(count == items.length) resize(2*items.length);
        items[count++] =item;
    }

    /**
     * 弹栈
     */
    public T pop(){
        //从栈顶删除元素
        T item = items[--count];
        items[count] = null;//避免游离
        if(count > 0 && count ==items.length/4) resize(items.length/2);  //栈占数组四份之一时，缩小数组至原来的一半
        return item;
    }

    /**
     * 返回最近加入栈的元素
     */
    public T peek(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return items[count-1];
    }

    /**
     * 自动调整栈大小
     */
    private void resize(int max){
        //将数组移动到一个大小为max的新数组
        T[] temp = (T[]) new Object[max];
        for(int i=0; i<items.length; i++){
            temp[i] = items[i];
        }
        items = temp;
    }

    /**
     * 生成迭代器
     */
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T>{
        //支持后进先出的迭代
        private int i = count;

        public boolean hasNext() {
            return i>0;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[--i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(item.equals("!END")){
                System.out.println(stack.toString());
                break;
            }
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
