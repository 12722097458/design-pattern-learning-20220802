package com.ityj.design.factory.factory_config;
/*
*   通过配置文件+工厂模式解耦
*   新加产品后只需要添加对应的Coffee实现类以及配置文件中配置其全类名即可
*
* */
public class TestMain {

    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.getCoffee("Cappuccino");
        System.out.println(coffee.getName());
    }

}
