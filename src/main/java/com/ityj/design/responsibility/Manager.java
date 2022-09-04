package com.ityj.design.responsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Manager extends Handler{

    protected Manager(int numStart, int numEnd) {
        super(numStart, numEnd);
    }

    @Override
    public void handleLeaveRequest(LeaveRequest leaveRequest) {
        log.info("部门经理对当前请假进行审批：{}-{}天-原因：{}", leaveRequest.getName(), leaveRequest.getLeaveDays(), leaveRequest.getComments());
    }
}
