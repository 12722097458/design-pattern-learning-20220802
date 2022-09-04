package com.ityj.design.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CloseState extends LiftState {
    @Override
    public void open() {
        log.info("open电梯");
        super.getContext().setCurrentState(Context.STATE_OPENED);
    }

    @Override
    public void close() {
        log.warn("当前已经是CloseState，无法再次close");
    }

    @Override
    public void stop() {
        log.info("stop电梯");
        super.getContext().setCurrentState(Context.STATE_STOPPED);
    }

    @Override
    public void run() {
        log.info("run电梯");
        super.getContext().setCurrentState(Context.STATE_RUNNING);
    }
}
