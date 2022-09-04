package com.ityj.design.observer.jdk_demo;

import lombok.Data;

import java.util.Observable;

@Data
public class Thief extends Observable {

    private String name;

    public void steal() {
        System.out.println("小偷" + name + "在偷东西！");
        super.setChanged();
        super.notifyObservers();
    }
}
