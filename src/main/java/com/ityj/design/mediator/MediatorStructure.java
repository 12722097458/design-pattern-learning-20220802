package com.ityj.design.mediator;

import lombok.Data;

@Data
public class MediatorStructure implements Mediator{

    private HouseOwner houseOwner;
    private Renter renter;

    @Override
    public void contact(String message, Person person) {
        if (person == houseOwner) {
            houseOwner.getMessage(message);
        } else if (person == renter) {
            renter.getMessage(message);
        }
    }
}
