package com.ityj.design.visitor;

public class Dog implements Animal{
    @Override
    public void accept(Person person) {
        person.feed(this);
    }
}
