package com.ityj.design.combination;

public class MainTest {
    public static void main(String[] args) {

        MenuComponent root = new Menu("Exceptions", 1);
        MenuComponent child01 = new MenuItem("Exception Master", 2);
        MenuComponent child02 = new MenuItem("Facility Exception", 2);
        MenuComponent child03 = new MenuItem("Obligor Exception", 2);
        MenuComponent child04 = new MenuItem("Unmatched Exception", 2);
        root.addChild(child01);
        root.addChild(child02);
        root.addChild(child03);
        root.addChild(child04);
        root.print();
    }
}
