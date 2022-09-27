package com.ityj.design.interpreter;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
*   加法表达式
* */
@Data
@AllArgsConstructor
public class Plus extends AbstractExpression{

    private AbstractExpression left;
    private AbstractExpression right;

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + "+" + right.toString() + ")";
    }

}
