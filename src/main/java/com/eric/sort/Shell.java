package com.eric.sort;

import com.eric.stdOut.StdOut;

/**
 * 希尔排序
 * @author Chen 2017/11/1
 */
public class Shell {
    private Shell(){}


    public static void sort(Comparable[] a){
        int n = a.length;
        int h = 1;
        while (h<n/3)
            h = 3*h +1;
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
    public static void main(String[] args) {
        String[] a = {"7","4","9","8","2","9","9","8","7"};
        Shell.sort(a);
        show(a);
    }



}
