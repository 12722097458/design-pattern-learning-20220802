package com.ityj.design.mediator;

public class HouseOwner extends Person {

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void contact(String message) {
        mediator.contact(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("房东" + name + "传递的信息是：" + message);
    }
}
