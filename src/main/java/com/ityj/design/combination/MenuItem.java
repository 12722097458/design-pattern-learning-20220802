package com.ityj.design.combination;

/*
*
*   叶子节点
* */
public class MenuItem extends MenuComponent{

    public MenuItem(String name, int level) {
        super.name = name;
        super.level = level;
    }

    @Override
    public void print() {
        for (int i = 0; i < super.level; i++) {
            System.out.print(" -");
        }
        System.out.println(super.getName());
    }
}
