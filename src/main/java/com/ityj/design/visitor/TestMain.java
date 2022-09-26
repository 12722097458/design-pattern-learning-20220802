package com.ityj.design.visitor;

/*
*   访问者模式
* */
public class TestMain {
    public static void main(String[] args) {
        Home home = new Home();
        home.add(new Dog());
        home.add(new Cat());
        home.action(new Owner());
    }
}
