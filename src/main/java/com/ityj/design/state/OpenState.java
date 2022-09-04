package com.ityj.design.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OpenState extends LiftState {
    @Override
    public void open() {
        log.warn("当前是OpenState，无法open");
    }

    @Override
    public void close() {
        log.info("close电梯");
        super.getContext().setCurrentState(Context.STATE_CLOSED);
    }

    @Override
    public void stop() {
        log.info("stop电梯");
        super.getContext().setCurrentState(Context.STATE_STOPPED);
    }

    @Override
    public void run() {
        log.warn("当前是OpenState，无法run");
    }
}
