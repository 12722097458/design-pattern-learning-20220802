package com.ityj.design.proxy.static_proxy;

public class TestMain {
    public static void main(String[] args) {

        SellTickets sellTickets = new TrainStationProxy(new TrainStation());

        sellTickets.sell();
    }
}
