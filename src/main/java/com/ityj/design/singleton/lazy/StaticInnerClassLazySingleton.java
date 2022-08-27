package com.ityj.design.singleton.lazy;

/*
*   静态内部类的方式实现单例
*
* */
public class StaticInnerClassLazySingleton {

    private StaticInnerClassLazySingleton() {

    }

    /*
    *   由于JVM加载外部类的过程中，是不会加载静态内部类的，只有内部类的属性或方法被调用时才会加载，并初始化其静态属性。
    * */
    private static class LazySingletonHolder {
        private static final StaticInnerClassLazySingleton INSTANCE = new StaticInnerClassLazySingleton();
    }

    public static StaticInnerClassLazySingleton getInstance() {
        return LazySingletonHolder.INSTANCE;
    }

}
