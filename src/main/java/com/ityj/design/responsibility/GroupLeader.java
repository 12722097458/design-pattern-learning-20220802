package com.ityj.design.responsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupLeader extends Handler{

    protected GroupLeader(int numStart, int numEnd) {
        super(numStart, numEnd);
    }

    @Override
    public void handleLeaveRequest(LeaveRequest leaveRequest) {
        log.info("小组leader对当前请假进行审批：{}-{}天-原因：{}", leaveRequest.getName(), leaveRequest.getLeaveDays(), leaveRequest.getComments());
    }
}
