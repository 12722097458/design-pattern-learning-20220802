package com.ityj.design.proxy.static_proxy;

/*
*   ้ๆไปฃ็
* */
public class TestMain {
    public static void main(String[] args) {

        SellTickets sellTickets = new TrainStationProxy(new TrainStation());

        sellTickets.sell();
    }
}
