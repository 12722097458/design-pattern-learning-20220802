package com.ityj.design.flyweight.jdkdemo;


/*
*   Integer i = 127;
*   装箱时用的是Integer.valueOf()方法
*   而valueOf用到了享元模式，默认会将-128  -  127存入缓存。不需要new对象
*
* */

public class TestMain {
    public static void main(String[] args) {

        Integer i = 127;
        Integer i2 = 127;

        System.out.println("i == i2 ? " + (i == i2));

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println("i3 == i4 ? " + (i3 == i4));

    }
}
