package com.ityj.design.singleton.hungry;

/*
*   单例模式-饿汉
* */
public class HungrySingleton {

    // 1. 私有构造方法
    private HungrySingleton() {}
    // 2. 对外暴露静态方法用来获取对象
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
