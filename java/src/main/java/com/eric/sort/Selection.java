package com.eric.sort;

import com.eric.stdOut.StdOut;

import javax.xml.transform.Templates;
import java.util.Comparator;

/**
 * 选择排序(第i次遍历数组，选择最小的放在第i位)
 * @author Chen 2017/10/30
 */
public class Selection {

    private Selection(){}

    /**
     * 选择排序实现方式
     * @param a
     */
    public static void sort(Comparable[] a){
        int n = a.length;
        for(int i = 0;i < n; i++){
            int min = i;
            for(int j = i + 1; j < n ; j++){
                if(less(a[j],a[min]))
                    min = j;
            }
            each(a,i,min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * 返回v < w
     * 返回v 是否小于w
     * @return
     */
    private static boolean less(Comparable v, Comparable w){
        return  v.compareTo(w) < 0;
    }

    /**
     * 返回v < w
     * 返回v 是否小于w
     * @return
     */
    private static boolean less(Comparator comparator, Object v ,Object w){
        return comparator.compare(v,w) <0 ;
    }

    /**
     * 交换数组元素位置
     */
    private static void each(Object[] a, int i ,int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j]=swap;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    // is the array a[] sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false;
        return true;
    }



    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; selection sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
//        String[] a = {"7","4","9","8","2","9","9","8","7"};
//        Selection.sort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }


        int [] a= {1,8,0,1,4,9,3,4,6,0,5};
        selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

//
//    public static void selectSort(int[] a){
//        int minIndex = 0;
//        int temp=0;
//        if((a==null)||(a.length ==0)){
//            return ;//判断输入的数据是否合法
//        }
//        for(int i= 0;i<a.length;i++){
//            minIndex = i;//最小数据数组下标
//            for(int j = i+1;j<a.length;j++){
//                if(a[j]<a[minIndex]){
//                    minIndex = j;
//                }
//            }
//            if(minIndex !=i){
//                temp = a[i];
//                a[i] = a[minIndex];
//                a[minIndex] = temp;
//            }
//        }
//    }


    public static void selectSort(int[] a){
        if(a ==null || a.length ==0) return;
        int minIndex = 0;
        int temp = 0;
        for(int i = 0;i<a.length;i++){
            minIndex = i;
            for(int j = i+1;j<a.length;j++){
                if(a[j]<a[minIndex]){
                    minIndex = j;
                }
            }
            if(i !=minIndex){
                temp = a[i];
                a[i]= a[minIndex];
                a[minIndex] = temp;
            }
        }

    }


































}
