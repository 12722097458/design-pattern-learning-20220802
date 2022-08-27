package com.ityj.design.factory.abstract_factory;

/*
*   当一系列产品被设计到一起工作时，用抽象工厂模式可以保证客户端始终只使用一个产品族的对象。（输入法更换皮肤-外观字体等全部改变）
*   缺点：
*       当产品族增加一个产品时，所有的工厂类都需要修改。
*           ==> 如果需要做甜品Dessert, BaseFactory/AmericanFactory/ItalyFactory 都需要修改
* */

public class TestMain {

    public static void main(String[] args) {
        BaseFactory factory = new ItalyFactory();
        Coffee coffee = factory.makeCoffee();
        Food food = factory.makeFood();
        System.out.println("coffee.getName() = " + coffee.getName());
        System.out.println("food.getName() = " + food.getName());
    }
    
}

