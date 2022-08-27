package com.ityj.design.factory.simple_static_factory;

public class TestMain {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        coffeeStore.makeCoffee("AmericanCoffee");
    }
}
