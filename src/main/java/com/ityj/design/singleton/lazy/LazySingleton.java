package com.ityj.design.singleton.lazy;

/*
*   双重校验锁 懒汉式实现单例
* */
public class LazySingleton {

    private LazySingleton() {
    }

    // volatile保证[可见性]和指令重排序
    private static volatile LazySingleton instance;

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
