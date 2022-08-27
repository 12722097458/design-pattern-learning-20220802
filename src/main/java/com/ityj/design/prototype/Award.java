package com.ityj.design.prototype;

import lombok.Data;

@Data
public class Award implements Cloneable {

    private Student student;

    @Override
    protected Award clone() throws CloneNotSupportedException {
        return (Award) super.clone();
    }

    public void show() {
        System.out.println("恭喜" + this.getStudent().getName() + "获得证书！");
    }

}
