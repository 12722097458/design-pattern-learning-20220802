package com.ityj.design.facade;

/*
*   外观模式：又叫门面模式，是一种通过为多个复杂的子系统提供一个一致的接口，而使这些接口更容易别访问的模式
*  隐藏细节
*
* */
public class TestMain {
    public static void main(String[] args) {
        SmartAppFacade smartAppFacade = new SmartAppFacade();
        smartAppFacade.say("on");
    }
}
