package com.ityj.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/*
*   享元工厂：提供一个单例工厂，构造一个容器缓存对象
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
