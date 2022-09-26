package com.ityj.design.visitor;

public class Cat implements Animal{
    @Override
    public void accept(Person person) {
        person.feed(this);
    }
}
