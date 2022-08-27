package com.ityj.design.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private TrainStation trainStation = new TrainStation();

    public SellTickets getObject() {
         return (SellTickets) Proxy.newProxyInstance(
                 trainStation.getClass().getClassLoader(),
                 trainStation.getClass().getInterfaces(),
                 new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invoke方法执行了。。。");
                method.invoke(trainStation, args);
                return null;
            }
        });
    }
}
