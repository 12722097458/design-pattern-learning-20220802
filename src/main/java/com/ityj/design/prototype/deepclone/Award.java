package com.ityj.design.prototype.deepclone;

import lombok.Data;

import java.io.Serializable;

@Data
public class Award implements Cloneable, Serializable {

    private Student student;

    @Override
    protected Award clone() throws CloneNotSupportedException {
        return (Award) super.clone();
    }

    public void show() {
        System.out.println("恭喜" + this.getStudent().getName() + "获得证书！");
    }

}
