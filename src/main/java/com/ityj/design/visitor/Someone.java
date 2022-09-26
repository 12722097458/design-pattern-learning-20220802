package com.ityj.design.visitor;

public class Someone implements Person{
    @Override
    public void feed(Dog dog) {
        System.out.println("Someone feed dog");
    }

    @Override
    public void feed(Cat cat) {
        System.out.println("Someone feed cat");
    }
}
