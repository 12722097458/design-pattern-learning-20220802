package com.ityj.design.interpreter;


import java.util.HashMap;
import java.util.Map;

/*
*   环境角色类
* */
public class Context {

    private Map<Variable, Integer> map = new HashMap<>();

    public void assign(Variable variable, Integer value) {
        map.put(variable, value);
    }

    public int getValue(Variable variable) {
        return map.get(variable);
    }

}
