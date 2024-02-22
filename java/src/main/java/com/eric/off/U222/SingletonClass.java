package com.eric.off.U222;

/**
 * 题目描述：设计一个类，我们只能生成该类的一个实例
 * @author Chen 2017/11/16
 */
public class SingletonClass {

    private SingletonClass() {
    }

    private static volatile  SingletonClass instance;

    public static SingletonClass getInstance(){
        if(instance ==null){
            synchronized (SingletonClass.class){
                if(instance ==null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
