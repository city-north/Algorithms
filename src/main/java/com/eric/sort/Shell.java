package com.eric.sort;

import com.eric.stdOut.StdOut;

import java.util.Arrays;

/**
 * 希尔排序
 * @author Chen 2017/11/1
 */
public class Shell {
    private Shell(){}



    public static void sort(Comparable[] a){
        int n = a.length;       //数组的长度
        int h = 1;
        while (h<n/3)
            h = 3*h +1;  //h为增量
        while (h >=1){
            for(int i = h; i<n;i++){
                for (int j = i;j>=h && less(a[j],a[j-h]);j-= h){
                    exch(a,j,j-h);
                }
            }
            h/=3;
        }
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }


    private static void shellSort(int[] a){
        if(a ==null || a.length <=1) return;
        int incrementNum = a.length/2;
        while(incrementNum >=1){
            for(int i = 0;i<a.length;i++){
                //进行插入排序
                for(int j=i;j<a.length-incrementNum;j=j+incrementNum){
                    if(a[j]>a[j+incrementNum]){
                        int temp = a[j];
                        a[j]=a[j+incrementNum];
                        a[j+incrementNum] = temp;
                    }
                }
            }
            incrementNum = incrementNum/2;
        }

    }
    public static void main(String[] args) {
        String[] a = {"7","5","3","2","8","9","1","6","4","8","9","4","3","9","8"};
        Shell.sort(a);
        show(a);
//        int a[] = {1,4,7,8,5,2,3,6,9,};
//        shellSort(a);
//        System.out.println(Arrays.toString(a));
    }
}
