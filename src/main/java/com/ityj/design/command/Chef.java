package com.ityj.design.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chef {

    public void prepareFood(String foodName, int foodCount) {
        log.info("厨师开始准备食物：{}，份数为：{}", foodName, foodCount);
    }

}
