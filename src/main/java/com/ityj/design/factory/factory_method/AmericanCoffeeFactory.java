package com.ityj.design.factory.factory_method;

public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee getCoffee() {
        return new AmericanCoffee();
    }
}
