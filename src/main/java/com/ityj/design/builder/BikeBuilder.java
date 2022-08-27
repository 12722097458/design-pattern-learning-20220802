package com.ityj.design.builder;

public abstract class BikeBuilder {

    protected Bike bike = new Bike();

    public abstract void buildFrame();
    public abstract void buildSeat();
    public abstract void buildTyre();

    public Bike newBike() {
        return this.bike;
    }

}
