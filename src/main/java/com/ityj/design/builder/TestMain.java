package com.ityj.design.builder;


/*
*   建造者模式
*   == 1. 封装性较好，将产品本身和创建的过程解耦。相同的创建过程可以创建出不同的产品对象
*
*   缺点：
*      产品一般有较多的共同点，组成部分相似
*
* */
public class TestMain {
    public static void main(String[] args) {
        BikeBuilder bikeBuilder = new HelloBikeBuilder();
        Director director = new Director(bikeBuilder);
        Bike bike = director.construct();
        System.out.println("bike = " + bike);
    }
}
