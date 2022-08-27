package com.ityj.design.singleton.singletonbreak.solve.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class IssueTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = SingletonReflectSolve.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonReflectSolve instance = (SingletonReflectSolve) constructor.newInstance();
        //SingletonReflectSolve instance2 = (SingletonReflectSolve) constructor.newInstance();

        SingletonReflectSolve instance3 = SingletonReflectSolve.getInstance();
        System.out.println("instance  = " + instance);
        //System.out.println("instance2 = " + instance2);
        System.out.println("instance3 = " + instance3);
    }
}
