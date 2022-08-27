package com.ityj.design.adapter.object_adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TFCardImpl {
    public String readData() {
        log.info("从TF卡读数据");
        return "Data from TF card";
    }

    public void writeData(String data) {
        log.info("向TF卡中写入数据:{}", data);
    }
}
