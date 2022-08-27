package com.ityj.design.facade;

public class SmartAppFacade {
    private TV tv;
    private Light light;

    public SmartAppFacade() {
        tv = new TV();
        light = new Light();
    }

    public void say(String message) {
        if (message.contains("on")) {
            on();
        } else if (message.contains("off")) {
            off();
        }
    }

    private void on() {
        light.on();
        tv.on();
    }
    private void off() {
        tv.off();
        light.off();
    }
}
