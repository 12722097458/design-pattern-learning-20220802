package com.ityj.design.interpreter;

import lombok.AllArgsConstructor;

/*
*   变量类
* */
@AllArgsConstructor
public class Variable extends AbstractExpression {

    private String name;

    @Override
    public int interpret(Context context) {
        // 返回变量的值
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
