package com.ityj.design.factory.factory_method;

/*
*   通过工厂方法，解决了普通工厂模式的开闭原则问题
*   如果新出了一个拿铁产品，name加一个拿铁类实现Coffee，再加一个工厂实现CoffeeFactory
*   不会对原有的代码进行修改。
*
* 缺点：
*   每增加一个产品，就需要增加两个类。增加了系统复杂度   ==》 容易发生类爆炸现象：类太多了
*
* */
public class TestMain {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        CappuccinoFactory cappuccinoFactory = new CappuccinoFactory();
        coffeeStore.setCoffeeFactory(cappuccinoFactory);
        // 做咖啡
        coffeeStore.makeCoffee();
    }
}
