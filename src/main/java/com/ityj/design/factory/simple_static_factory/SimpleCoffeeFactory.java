package com.ityj.design.factory.simple_static_factory;

/*
*   这时候new AmericanCoffee()工厂还会出现耦合，如果新增咖啡类型，工厂类还需要修改
*   违反了开闭原则：对扩展开放，修改关闭。
*
* */
public class SimpleCoffeeFactory {

    public static Coffee getCoffee(String type) {
        if ("AmericanCoffee".equals(type)) {
            return new AmericanCoffee();
        } else if ("Cappuccino".equals(type)) {
            return new Cappuccino();
        } else {
            throw new RuntimeException("此咖啡类型不存在！");
        }
    }
}
