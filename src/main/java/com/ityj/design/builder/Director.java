package com.ityj.design.builder;

public class Director {

    private BikeBuilder builder;

    public Director(BikeBuilder builder) {
        this.builder = builder;
    }

    public Bike construct() {
        this.builder.buildFrame();
        this.builder.buildSeat();
        this.builder.buildTyre();
        return this.builder.newBike();
    }
}
