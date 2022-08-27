package com.ityj.design.adapter.object_adapter;

import lombok.extern.slf4j.Slf4j;

// SD 卡，电脑能直接读数据
@Slf4j
public class SDCardImpl {

    public String readData() {
        log.info("从SD卡读数据");
        return "Data from SD card";
    }

    public void writeData(String data) {
        log.info("向SD卡中写入数据:{}", data);
    }
}
