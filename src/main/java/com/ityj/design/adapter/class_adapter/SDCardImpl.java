package com.ityj.design.adapter.class_adapter;

import lombok.extern.slf4j.Slf4j;

// SD 卡，电脑能直接读数据
@Slf4j
public class SDCardImpl implements SDCard {

    @Override
    public String readData() {
        log.info("从SD卡读数据");
        return "Data from SD card";
    }

    @Override
    public void writeData(String data) {
        log.info("向SD卡中写入数据:{}", data);
    }
}
