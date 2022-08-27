package com.ityj.design.singleton.singletonbreak.solve.seri;

import java.io.Serializable;

/*
*   当用outputstream把对象Serializable导出成文件，再次读取这个文件会破坏单例，出现多个不同的对象
*   ==>
*   解决
*   java.io.ObjectInputStream.readOrdinaryObject
*   添加 readResolve()方法
*
* */
public class SingletonSerializableSolve implements Serializable {

    private SingletonSerializableSolve() {}
    private static final SingletonSerializableSolve INSTANCE = new SingletonSerializableSolve();

    public static SingletonSerializableSolve getInstance() {
        return INSTANCE;
    }

    // 返回值是Object
    public Object readResolve() {
        return INSTANCE;
    }
}
