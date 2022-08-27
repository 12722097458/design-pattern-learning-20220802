package com.ityj.design.singleton.singletonbreak.solve.reflect;

import java.io.Serializable;

/*
    通过反射
    可以通过私有构造方法创建出不同的实例
    解决：
    对私有构造方法进行逻辑判断，对结果进行限制。

* */
public class SingletonReflectSolve implements Serializable {

    private static volatile boolean isExists = false;

    private SingletonReflectSolve() {
        synchronized (SingletonReflectSolve.class) {
            if (isExists) {
                throw new RuntimeException("当前实例已存在，无法再次新建！");
            }
        }
        isExists = true;
    }
    private static final SingletonReflectSolve INSTANCE = new SingletonReflectSolve();

    public static SingletonReflectSolve getInstance() {
        return INSTANCE;
    }
}
