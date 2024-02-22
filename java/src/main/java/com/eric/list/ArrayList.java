package com.eric.list;

import java.util.*;

/**
 * @author Chen 2017/11/13
 */
public class ArrayList<E> implements List {

    transient Object[] elementData; //数组存的数据
    private int size;   //数组大小
    private static final Object[] EMPTY_ELEMENTDATA = {};//空数据
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};//默认容量的空数据

    /**
     * 有参构造
     * @param initialCapacity 初始容量
     */
    public ArrayList(int initialCapacity) {
        if(initialCapacity >0){
            this.elementData = new Object[initialCapacity];
        }else if(initialCapacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("不合法的初始容量："+initialCapacity);
        }
    }

    /**
     * 无参构造
     */
    public ArrayList() {
        this.elementData =DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size ==0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >=0;
    }

    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public boolean add(Object o) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public boolean addAll(int index, Collection c) {
        return false;
    }


    public void clear() {

    }

    public Object get(int index) {
        return null;
    }

    public Object set(int index, Object element) {
        return null;
    }

    public void add(int index, Object element) {

    }

    public Object remove(int index) {
        return null;
    }

    /**
     * 返回在数组中出现指定元素的第一个索引
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        if( o ==null){
            for(int i = 0;i<size;i++)
                if(elementData[i] == null)
                    return i;
        }else {
            for(int i = 0;i<size;i++){
                if(o.equals(elementData[i]))
                    return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator listIterator() {
        return null;
    }

    public ListIterator listIterator(int index) {
        return null;
    }

    public List subList(int fromIndex, int toIndex) {
        return null;
    }


    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
