package com.ityj.design.state;


import lombok.Data;

@Data
public abstract class LiftState {

    protected Context context;

    public abstract void open();
    public abstract void close();
    public abstract void stop();
    public abstract void run();
}
