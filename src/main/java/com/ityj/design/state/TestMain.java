package com.ityj.design.state;

public class TestMain {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(Context.STATE_STOPPED);
        context.run();
        context.stop();
        context.open();
        context.close();
    }
}
