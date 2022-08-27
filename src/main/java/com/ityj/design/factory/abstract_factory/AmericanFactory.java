package com.ityj.design.factory.abstract_factory;

public class AmericanFactory implements BaseFactory{

    @Override
    public Coffee makeCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Food makeFood() {
        return new Hamburger();
    }
}
