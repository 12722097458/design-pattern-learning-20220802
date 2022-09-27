package com.ityj.design.memento.black_box;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameRole {

    private int vit;
    private int atk;
    private int def;

    public void initState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    public RoleStateMemento saveState() {
        return new RoleStateMemento(this.vit, this.atk, this.def);
    }

    public void recover(Memento memento) {
        RoleStateMemento roleStateMemento = (RoleStateMemento) memento;
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    public void show() {
        System.out.println("vit = " + vit);
        System.out.println("atk = " + atk);
        System.out.println("def = " + def);
    }

    public void fight() {
        this.vit = 50;
        this.atk = 50;
        this.def = 50;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class RoleStateMemento implements Memento {
        private int vit;
        private int atk;
        private int def;
    }


}
