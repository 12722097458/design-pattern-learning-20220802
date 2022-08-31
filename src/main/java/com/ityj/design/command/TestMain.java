package com.ityj.design.command;

import java.util.List;
/*
*
*   命令模式 - 服务员唤醒厨师进行食物准备：通过中间件实现
*
* */
public class TestMain {
    public static void main(String[] args) {
        Order order = new Order();
        order.setTableNo(1);
        order.addFood("汉堡", 3);
        order.addFood("可乐", 1);
        order.addFood("雪碧", 2);
        OrderCommand orderCommand = new OrderCommand();
        orderCommand.setOrder(order);
        orderCommand.setReceiver(new Chef());

        Order order2 = new Order();
        order2.setTableNo(1);
        order2.addFood("披萨", 3);
        order2.addFood("牛奶", 1);
        OrderCommand orderCommand2 = new OrderCommand();
        orderCommand2.setOrder(order2);
        orderCommand2.setReceiver(new Chef());

        Waiter waiter = new Waiter();
        waiter.setCommands(List.of(orderCommand, orderCommand2));
        waiter.execCommand();
    }
}
