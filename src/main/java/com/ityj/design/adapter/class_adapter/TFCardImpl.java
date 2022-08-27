package com.ityj.design.adapter.class_adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TFCardImpl implements TFCard {
    @Override
    public String readData() {
        log.info("从TF卡读数据");
        return "Data from TF card";
    }

    @Override
    public void writeData(String data) {
        log.info("向TF卡中写入数据:{}", data);
    }
}
