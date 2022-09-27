package com.ityj.design.interpreter;

public class TestMain {
    public static void main(String[] args) {

        Context context = new Context();
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");
        context.assign(a, 1);
        context.assign(b, 2);
        context.assign(c, 3);
        context.assign(d, 88);

        Plus plus = new Plus(a, new Plus(b, c));
        Minus minus = new Minus(d, plus);
        System.out.println(minus.toString()  + " = " + minus.interpret(context));


    }
}
