package com.ityj.design.adapter.class_adapter;

import java.util.Arrays;

/*
*
* 类适配器
*
* */
public class TestMain {
    public static void main(String[] args) {

        // org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
        // org.springframework.web.servlet.HandlerAdapter.handle
        // DispatcherServlet并不直接处理所有控制器，而是通过HandlerAdapter接口来调用，
        // 不同的控制器类型有对应的适配器实现（如RequestMappingHandlerAdapter），屏蔽了底层处理的差异

//        Arrays.asList()   将一个数组适配为List接口进行访问

        Computer computer = new Computer(new SDCardImpl());
        String data = computer.readData();
        System.out.println("data = " + data);
        System.out.println("==============================");

        Computer computer2 = new Computer(new SDAdapterTF());
        String data2 = computer2.readData();
        System.out.println("data2 = " + data2);

    }
}
