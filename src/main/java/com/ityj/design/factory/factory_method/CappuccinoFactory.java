package com.ityj.design.factory.factory_method;

public class CappuccinoFactory implements CoffeeFactory{
    @Override
    public Coffee getCoffee() {
        return new Cappuccino();
    }
}
