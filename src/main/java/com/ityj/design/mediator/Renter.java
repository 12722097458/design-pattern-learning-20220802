package com.ityj.design.mediator;

public class Renter extends Person {

    public Renter(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void contact(String message) {
        mediator.contact(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("租客" + name + "传递的信息是：" + message);
    }
}
