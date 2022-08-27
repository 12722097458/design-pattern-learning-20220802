package com.ityj.design.factory.simple_static_factory;

public class CoffeeStore {

    public void makeCoffee(String type) {
        Coffee coffee = SimpleCoffeeFactory.getCoffee(type);
        System.out.println(coffee.getName());
        coffee.addMilk();
    }

}
