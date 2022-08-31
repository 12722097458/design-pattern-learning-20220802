package com.ityj.design.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractCook {

    public void cookProcess() {
        prepareFood();
        cook();
        cleanUp();
    }

    protected void cleanUp() {
        log.info("吃完饭收拾房间！");
    }

    protected abstract void cook();

    protected void prepareFood() {
        log.info("准备食物！");
    }
}
