package com.ityj.design.combination;

import java.util.ArrayList;
import java.util.List;

/*
 *   树枝节点
 * */

public class Menu extends MenuComponent{

    private List<MenuComponent> menuComponentList = new ArrayList<>();

    public Menu(String name, int level) {
        super.name = name;
        super.level = level;
    }

    @Override
    public void addChild(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void print() {
        for (int i = 0; i < super.level; i++) {
            System.out.print(" -");
        }
        System.out.println(super.getName());
        menuComponentList.forEach(MenuComponent::print);
    }
}
