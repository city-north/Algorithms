package com.eric.sort;


import sun.security.util.Length;

import java.text.ParseException;
import java.util.Comparator;

/**
 * 插入排序
 * @author Chen 2017/10/30
 */
public class Insertion {


    /**
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        for(int i = 0;i < n ; i++){
            for(int j =i; j > 0 && less(a[j],a[j-1]);j--){
                exch(a, j, j-1);
            }
        }
    }


    public static void insertSort(int[] array){
        for(int i = 1;i<array.length;i++){
            if(array[i] < array[i-1]){//0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，否则认为0~i位也是有序的，忽略此次
                int temp = array[i];  //将第I位元素放入临时变量
                int k = i - 1;
                for(int j = k;j >= 0 && temp< array[j];j--){//从第i-1位向前遍历并移位，直至找到小于第i位值停止
                    array[j+1] = array[j];
                    k--;
                }
                array[k+1] = temp;
            }
        }
    }
    public static void myInsertSort(int[] a){
        if(a ==null || a.length ==0) return;
        for(int i = 1; i< a.length ;i++){
            if(a[i] < a[i-1]){
                int move = i-1;
                int temp = a[i];
                for(int j= move;j>=0 && a[j]>temp;j--){
                    a[j+1] = a[j];
                    move--;
                }
              a[move+1]=temp;
            }



























    }
//    public static void myInsertSort(int[] a){
//        if(a==null ||a.length ==0) return;
//        for(int i=1;i<a.length ;i++){
//            if(a[i]<a[i-1]){
//                int moveIndex = i-1; //最多挪动的位置
//                int temp = a[i];
//                for (int j=moveIndex;j>=0 && temp<a[j];j--){
//                    a[j+1]=a[j];
//                    moveIndex--;
//                }
//                a[moveIndex+1] = temp;
//            }
//        }


    }














    public static void printArray(int[] array) {
        System.out.println("--------------------");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("--------------------");
    }



    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    public static void main(String[] args) {
//        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
//        Insertion.sort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//
//        int[] a = {7,4,9,8,2,9,9,8,7};
        int[] a = {7,5,3,9,5,1,8,5,2,4,5,6};
        myInsertSort(a);
        printArray(a);
    }
}
