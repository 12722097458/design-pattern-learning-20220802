package com.ityj.design.adapter.class_adapter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Computer {

    private SDCard sdCard;

    public Computer(SDCard sdCard) {
        this.sdCard = sdCard;
    }

    public String readData() {
        log.info("Computer读数据");
        return sdCard.readData();
    }

}
