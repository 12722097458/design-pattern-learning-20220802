package com.ityj.design.proxy.static_proxy;

/*
*   静态代理
* */
public class TestMain {
    public static void main(String[] args) {

        SellTickets sellTickets = new TrainStationProxy(new TrainStation());

        sellTickets.sell();
    }
}
