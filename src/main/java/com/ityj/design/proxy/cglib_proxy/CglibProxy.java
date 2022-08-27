package com.ityj.design.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {

    private TrainStation trainStation = new TrainStation();

    public TrainStation getCglibProxyObject() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TrainStation.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("代理点收取一定服务费...");
                Object invoke = method.invoke(trainStation, objects);
                return invoke;
            }
        });
        TrainStation proxy = (TrainStation) enhancer.create();
        return proxy;
    }
}
