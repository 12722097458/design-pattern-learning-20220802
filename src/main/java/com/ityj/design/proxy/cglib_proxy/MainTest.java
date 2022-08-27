package com.ityj.design.proxy.cglib_proxy;

public class MainTest {
    public static void main(String[] args) {

        CglibProxy cglibProxy = new CglibProxy();
        TrainStation cglibProxyObject = cglibProxy.getCglibProxyObject();
        cglibProxyObject.sell();

    }
}
