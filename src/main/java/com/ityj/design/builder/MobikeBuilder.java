package com.ityj.design.builder;

public class MobikeBuilder extends BikeBuilder {
    @Override
    public void buildFrame() {
        super.bike.setFrame("摩拜车架");
    }

    @Override
    public void buildSeat() {
        super.bike.setSeat("摩拜车座");
    }

    @Override
    public void buildTyre() {
        super.bike.setTyre("摩拜轮胎");
    }
}
