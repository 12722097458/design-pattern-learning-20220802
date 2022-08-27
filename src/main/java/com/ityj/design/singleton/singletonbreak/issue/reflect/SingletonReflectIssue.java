package com.ityj.design.singleton.singletonbreak.issue.reflect;

import java.io.Serializable;

/*
    通过反射
    可以通过私有构造方法创建出不同的实例

* */
public class SingletonReflectIssue implements Serializable {

    private SingletonReflectIssue() {}
    private static final SingletonReflectIssue INSTANCE = new SingletonReflectIssue();

    public static SingletonReflectIssue getInstance() {
        return INSTANCE;
    }
}
