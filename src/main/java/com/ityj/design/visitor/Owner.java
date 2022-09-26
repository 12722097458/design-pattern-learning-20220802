package com.ityj.design.visitor;

public class Owner implements Person{
    @Override
    public void feed(Dog dog) {
        System.out.println("Owner feed dog");
    }

    @Override
    public void feed(Cat cat) {
        System.out.println("Owner feed cat");
    }
}
