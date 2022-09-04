package com.ityj.design.state;

public class Context {
    public static final LiftState STATE_RUNNING = new RunState();
    public static final LiftState STATE_STOPPED = new StopState();
    public static final LiftState STATE_CLOSED = new CloseState();
    public static final LiftState STATE_OPENED = new OpenState();

    private LiftState currentState;

    public LiftState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(LiftState currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public void open() {
        this.currentState.open();
    }

    public void close() {
        this.currentState.close();
    }

    public void stop() {
        this.currentState.stop();
    }

    public void run() {
        this.currentState.run();
    }
}
