package com.ityj.design.adapter.class_adapter;

/*
*
* 类适配器
*
* */
public class TestMain {
    public static void main(String[] args) {

        Computer computer = new Computer(new SDCardImpl());
        String data = computer.readData();
        System.out.println("data = " + data);
        System.out.println("==============================");

        Computer computer2 = new Computer(new SDAdapterTF());
        String data2 = computer2.readData();
        System.out.println("data2 = " + data2);

    }
}
