package com.ityj.design.factory.factory_method;

import lombok.Setter;

@Setter
public class CoffeeStore {

    private CoffeeFactory coffeeFactory;

    public void makeCoffee() {
        Coffee coffee = this.coffeeFactory.getCoffee();
        coffee.addMilk();
        coffee.addSugar();
        System.out.println("coffee的Name = " + coffee.getName());
    }

}
