package com.ityj.design.builder;

public class HelloBikeBuilder extends BikeBuilder{
    @Override
    public void buildFrame() {
        super.bike.setFrame("Hello车架");
    }

    @Override
    public void buildSeat() {
        super.bike.setSeat("Hello真皮车座");
    }

    @Override
    public void buildTyre() {
        super.bike.setTyre("Hello橡胶轮胎");
    }
}
