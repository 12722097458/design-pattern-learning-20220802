package com.ityj.design.visitor;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private List<Animal> animals = new ArrayList<>();

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void action(Person person) {
        animals.forEach(x -> x.accept(person));
    }

}
