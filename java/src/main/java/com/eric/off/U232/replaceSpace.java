package com.eric.off.U232;

/**
 * @author Chen 2017/11/16
 */
public class replaceSpace {

    public static String replace(StringBuffer str) {
        if(str == null){
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for(int i = 0;i<str.length();i++)
        if (str.charAt(i) == ' '){
            newStr.append('%');
            newStr.append('2');
            newStr.append('0');
        }else {
            newStr.append(str.charAt(i));
        }
        return newStr.toString();
    }

    /**
     *在同一个Stringbuffer
     * @param str
     * @return
     */
    public static String replace2(StringBuffer str) {
        int length = str.length();
        int spaceNum =0;
        for(int i = 0;i<length;i++){
            if(str.charAt(i)==' '){
                spaceNum++;
            }
        }
        int oldEnd = str.length()-1;
        int newLength= length+spaceNum*2;
        int newEnd = newLength -1;
        str.setLength(newLength);
        while (oldEnd >=0 && oldEnd<newEnd){
            if(str.charAt(oldEnd)==' '){
                str.setCharAt(newEnd--,'0');
                str.setCharAt(newEnd--,'2');
                str.setCharAt(newEnd--,'%');
            }else {
                //从原结尾遍历拷贝到现结尾
                str.setCharAt(newEnd--,str.charAt(oldEnd));
            }
            oldEnd--;
        }
        return str.toString();
    }
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We Are Happy.");
        String replace = replace2(stringBuffer);
        System.out.println(replace);
    }
}
