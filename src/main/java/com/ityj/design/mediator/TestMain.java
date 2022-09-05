package com.ityj.design.mediator;

/*
*   中介者模式
* */
public class TestMain {
    public static void main(String[] args) {
        MediatorStructure mediatorStructure = new MediatorStructure();
        Renter renter = new Renter("租客-Jack", mediatorStructure);
        HouseOwner houseOwner = new HouseOwner("房东-Rose", mediatorStructure);
        mediatorStructure.setRenter(renter);
        mediatorStructure.setHouseOwner(houseOwner);
        renter.contact("租房三人间");
        houseOwner.contact("有房出租");
    }
}
