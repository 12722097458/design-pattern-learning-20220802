package com.ityj.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/*
*   享元工厂：提供一个单例工厂，构造一个容器缓存对象
*
*   意图： 运用共享技术支持大量细粒度对象，节省内存。
实现关键：
分离内部状态（可共享、不可变）和外部状态（不可共享、可变）。
使用享元工厂来缓存和管理共享对象。
经典应用：
Java String Pool
Integer.valueOf(int) 缓存
各种连接池、线程池
*
* */
public class BoxFactory {

    private static BoxFactory boxFactory = new BoxFactory();

    public static BoxFactory getInstance() {
        return boxFactory;
    }

    private Map<String, AbstractBox> boxMap;
    public BoxFactory() {
        boxMap = new HashMap<>();
        boxMap.put("J", new JBox());
        boxMap.put("S", new SBox());
    }

    public AbstractBox getBox(String name) {
        return boxMap.get(name);
    }

}
