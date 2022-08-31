package com.ityj.design.command;

import lombok.Data;

import java.util.List;

@Data
public class Waiter {

    private List<OrderCommand> commands;

    public void execCommand() {
        System.out.println("订单来了！");
        commands.forEach(Command::execute);
        System.out.println("食物准备完毕！");
    }


}
