package com.ityj.design.observer;

/*
*   观察者模式
* */
public class TestMain {
    public static void main(String[] args) {

        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();
        subscriptionSubject.addObserver(new WeXinUser("Jack0"));
        subscriptionSubject.addObserver(new WeXinUser("Jack2"));
        subscriptionSubject.addObserver(new WeXinUser("Jack3"));

        subscriptionSubject.notifyObservers("Hello");

    }
}
