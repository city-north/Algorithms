package com.eric;
public class ClassTest{
    String str = new String("hello");
    char[] ch = {'a','b','c'};
    public void fun(String str, char ch[]){
        str="world";
        ch[0]='d';
    }
    public static void doSomething(Integer integer){
        integer=new Integer(2);
    }
    public static void main(String[] args) {
        Integer var1=new Integer(1);
        Integer var2=var1;
        doSomething(var2);
        System.out.print(var1.intValue());
        System.out.print(var1==var2);
    }
}