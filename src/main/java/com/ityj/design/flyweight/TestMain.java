package com.ityj.design.flyweight;

/*
*   享元模式
*
* */
public class TestMain {
    public static void main(String[] args) {

        AbstractBox box = BoxFactory.getInstance().getBox("J");
        box.display("黄色");

        AbstractBox box2 = BoxFactory.getInstance().getBox("J");

        System.out.println("(box == box2) = " + (box == box2));
        
    }
}

