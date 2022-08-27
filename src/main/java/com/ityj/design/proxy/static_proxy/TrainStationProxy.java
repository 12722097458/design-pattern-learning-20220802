package com.ityj.design.proxy.static_proxy;

import lombok.Data;

@Data
public class TrainStationProxy implements SellTickets{

    private TrainStation trainStation;

    public TrainStationProxy(TrainStation trainStation) {
        this.trainStation = trainStation;
    }

    @Override
    public void sell() {
        System.out.println("代购点收取一定的服务费！");
        trainStation.sell();
    }
}
