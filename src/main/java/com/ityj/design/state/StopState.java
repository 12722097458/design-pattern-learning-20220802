package com.ityj.design.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StopState extends LiftState {
    @Override
    public void open() {
        log.info("open电梯");
        super.getContext().setCurrentState(Context.STATE_OPENED);
    }

    @Override
    public void close() {
        log.info("close电梯");
        super.getContext().setCurrentState(Context.STATE_CLOSED);
    }

    @Override
    public void stop() {
        log.warn("已经是StopState，无法stop");
    }

    @Override
    public void run() {
        log.info("run电梯");
        super.getContext().setCurrentState(Context.STATE_RUNNING);
    }
}
