package com.ityj.design.responsibility;

/*
*   职责链模式
* */
public class TestMain {

    public static void main(String[] args) {

        Handler groupLeader = new GroupLeader(Handler.NUM_ZERO, Handler.NUM_ONE);   // [0, 1]
        Handler manager = new Manager(Handler.NUM_ONE, Handler.NUM_THREE);          // (1, 3]
        Handler boss = new Boss(Handler.NUM_THREE, Handler.NUM_SEVEN);              // (3, 7]
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(boss);

        LeaveRequest leaveRequest = new LeaveRequest("Jack", 6, "请假");
        groupLeader.submit(leaveRequest);
    }
}
