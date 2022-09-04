package com.ityj.design.observer;

public class WeXinUser implements Observer{
    private String name;

    public WeXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(this.name + "收到消息：" + message);
    }
}
