package com.ityj.design.proxy.jdk_proxy;

/*
*   JDK 动态代理
* */
public class MainTest {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        SellTickets proxyFactoryObject = proxyFactory.getObject();
        proxyFactoryObject.sell();
    }
}
