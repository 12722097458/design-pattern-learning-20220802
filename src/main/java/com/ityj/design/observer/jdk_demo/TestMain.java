package com.ityj.design.observer.jdk_demo;

public class TestMain {
    public static void main(String[] args) {

        Thief thief = new Thief();
        thief.setName("强哥");
        thief.addObserver(new Policeman());
        thief.steal();
    }
}
