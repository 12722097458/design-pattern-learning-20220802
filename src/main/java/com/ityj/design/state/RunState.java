package com.ityj.design.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunState extends LiftState {
    @Override
    public void open() {
        log.warn("当前是RunState，无法open");
    }

    @Override
    public void close() {
        log.warn("当前是RunState，无法已经是close的了");
    }

    @Override
    public void stop() {
        log.info("stop电梯");
        super.getContext().setCurrentState(Context.STATE_STOPPED);
    }

    @Override
    public void run() {
        log.warn("当前是RunState，无法run了");
    }
}
