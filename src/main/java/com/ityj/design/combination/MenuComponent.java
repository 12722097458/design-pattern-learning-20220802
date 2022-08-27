package com.ityj.design.combination;

public abstract class MenuComponent {
    protected String name;
    protected int level;

    public void addChild(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("当前操作异常！");
    }

    public String getName() {
        return this.name;
    }

    public abstract void print();

}
