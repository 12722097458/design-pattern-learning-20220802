package com.ityj.design.factory.abstract_factory;

public class ItalyFactory implements BaseFactory{
    @Override
    public Coffee makeCoffee() {
        return new Cappuccino();
    }

    @Override
    public Food makeFood() {
        return new Pizza();
    }
}
