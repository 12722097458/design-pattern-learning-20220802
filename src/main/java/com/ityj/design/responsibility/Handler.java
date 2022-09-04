package com.ityj.design.responsibility;

import lombok.Data;

@Data
public abstract class Handler {
    public static final int NUM_ZERO = 0;
    public static final int NUM_ONE = 1;
    public static final int NUM_THREE = 3;
    public static final int NUM_SEVEN = 7;

    private int numStart;
    private int numEnd;
    private Handler nextHandler;

    protected Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public abstract void handleLeaveRequest(LeaveRequest leaveRequest);

    public final void submit(LeaveRequest leaveRequest) {
        this.handleLeaveRequest(leaveRequest);
        if (this.nextHandler != null && leaveRequest.getLeaveDays() > this.getNumEnd()) {
            this.nextHandler.submit(leaveRequest);
        }
    }

}
