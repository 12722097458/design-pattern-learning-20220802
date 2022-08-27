package com.ityj.design.singleton.hungry;

public class TestDemo {
    public static void main(String[] args) {

        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();

        System.out.println("instance  = " + instance);
        System.out.println("instance1 = " + instance1);

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton == enumSingleton2);
    }
}
