package com.ityj.design.observer;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{

    private List<Observer> allUsers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        allUsers.add(observer);
    }

    @Override
    public void notifyObservers(String message) {
        allUsers.forEach(x -> x.update(message));
    }
}
