package com.ityj.design.command;

import lombok.Data;

@Data
public class OrderCommand implements Command {

    private Chef receiver;
    private Order order;

    @Override
    public void execute() {
        order.getFoodMap().forEach((k, v)-> receiver.prepareFood(k, v));
    }
}
