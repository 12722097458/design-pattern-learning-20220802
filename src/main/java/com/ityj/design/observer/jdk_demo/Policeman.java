package com.ityj.design.observer.jdk_demo;

import java.util.Observable;
import java.util.Observer;

public class Policeman implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("警察抓到小偷" + ((Thief) o).getName() + "在偷东西！");
    }
}
