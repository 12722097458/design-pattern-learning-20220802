package com.ityj.design.singleton.singletonbreak.issue.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
*  破坏单例，通过反射创建两个对象
* */
@Slf4j
public class IssueTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = SingletonReflectIssue.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonReflectIssue instance = (SingletonReflectIssue) constructor.newInstance();
        SingletonReflectIssue instance2 = (SingletonReflectIssue) constructor.newInstance();
        System.out.println("instance  = " + instance);
        System.out.println("instance2 = " + instance2);
    }
}
