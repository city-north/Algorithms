package com.eric.practice.TwoDArray;

/**
 *  二维数组中查找
 * @author Chen 2017/10/26
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class find {

    public static boolean Find(int target, int [][] array) {
        int len = array.length -1;
        int i = 0;
        while((len >= 0)&&(i<array[0].length)){
            if(array[len][i] >target){
                len --;
            }else if(array[len][i]< target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] array = {{1,2,3,4,5},{2,3,4,5,6}};
        System.out.println(Find(4,array));
    }
}
