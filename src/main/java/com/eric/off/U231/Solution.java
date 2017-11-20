package com.eric.off.U231;

/**
 * 题目描述：二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的顺序排序。
 * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否包含该整数
 * @author Chen 2017/11/16
 */
public class Solution {

    public static boolean find(int target, int [][] array) {
        int column = array[0].length-1;//列数
        int row = 0;
        while (column >=0 && row<array.length){
            if(array[row][column] == target){
                return true;
            }
            else if(array[row][column] >target){
                column --;
            }
            else {
                row++;
            }
        }
        return  false;
    }


    public static boolean find2(int target, int [][] array) {
        int column = 0;
        int row = array.length-1;
        while (column<array[0].length && row>=0){
            if(array[row][column] == target){
                return true;
            }else if(array[row][column] > target){
                row --;
            }else {
                column ++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int [][] array ={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean b = find2(26, array);
        System.out.println(b);
    }
}
