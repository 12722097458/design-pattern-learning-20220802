package com.ityj.design.singleton.singletonbreak.issue.seri;

import java.io.Serializable;

/*
*   当用outputstream把对象Serializable导出成文件，再次读取这个文件会破坏单例，出现多个不同的对象
* */
public class SingletonSerializableIssue implements Serializable {

    private SingletonSerializableIssue() {}
    private static final SingletonSerializableIssue INSTANCE = new SingletonSerializableIssue();

    public static SingletonSerializableIssue getInstance() {
        return INSTANCE;
    }
}
