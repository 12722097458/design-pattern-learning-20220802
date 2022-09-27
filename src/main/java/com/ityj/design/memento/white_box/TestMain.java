package com.ityj.design.memento.white_box;

// 备忘录模式: 白箱模式 会被修改不安全
public class TestMain {
    public static void main(String[] args) {

        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.show();

        System.out.println("战斗前，存档！");
        RoleStateManager roleStateManager = new RoleStateManager();
        roleStateManager.setRoleStateMemento(gameRole.saveState());
        //roleStateManager.getRoleStateMemento().setAtk(999999999);
        gameRole.fight();
        System.out.println("战斗结束。。。");
        gameRole.show();

        System.out.println("读取存档：");
        gameRole.recover(roleStateManager.getRoleStateMemento());
        gameRole.show();

    }
}
