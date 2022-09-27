package com.ityj.design.memento.black_box;

// 备忘录模式: 黑箱模式
public class TestMain {
    public static void main(String[] args) {

        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.show();

        System.out.println("战斗前，存档！");
        RoleStateManager roleStateManager = new RoleStateManager();
        roleStateManager.setMemento(gameRole.saveState());
        // roleStateManager.getMemento().setXXX无法修改
        gameRole.fight();
        System.out.println("战斗结束。。。");
        gameRole.show();

        System.out.println("读取存档：");
        gameRole.recover(roleStateManager.getMemento());
        gameRole.show();

    }
}
