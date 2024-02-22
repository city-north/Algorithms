package com.eric.stack;


import com.eric.stdIn.StdIn;
import com.eric.stdOut.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 下压堆栈（链表实现）
 * @author Chen 2017/10/20
 */
public class LinkedStack<T> implements Iterable<T> {
    private int count;
    private Node first;

    private class Node{
        private T item;
        private Node next;
    }

    /**
     * 构造方法,初始化一个空的链表栈
     */
    public LinkedStack() {
        count = 0;
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size (){
        return count;
    }

    /**
     * 压栈
     */
    public void push(T item){
        Node oldFirst = first;  //先暂存原数据
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        count ++;
        assert check();
    }

    /**
     * 弹栈
     */
    public T pop(){
        if(isEmpty()) throw  new NoSuchElementException("Stack underflow");
        T item = first.item;    //保存最上层的节点内容
        first = first.next;     //弹栈
        count --;
        assert check();
        return item;
    }

    /**
     * 获得最近添加的元素
     */
    public T peek(){
        if(isEmpty()) throw new NoSuchElementException("stack underflow");
        return first.item;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for(T item :this){
            s.append(item +"");
        }
        return s.toString();
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<T>{
        private Node current = first;
        public boolean hasNext()  { return current != null;}

        public void remove()      { throw new UnsupportedOperationException();  }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }


    // check internal invariants
    private boolean check() {

        // check a few properties of instance variable 'first'
        if (count < 0) {
            return false;
        }
        if (count == 0) {
            if (first != null) return false;
        }
        else if (count == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first == null)      return false;
            if (first.next == null) return false;
        }

        // check internal consistency of instance variable n
        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= count; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != count) return false;

        return true;
    }
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }

}
