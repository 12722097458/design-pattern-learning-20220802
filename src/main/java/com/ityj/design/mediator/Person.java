package com.ityj.design.mediator;

import lombok.Data;

@Data
public abstract class Person {

    protected String name;
    protected Mediator mediator;

    protected Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public abstract void contact(String message);
    public abstract void getMessage(String message);

}
