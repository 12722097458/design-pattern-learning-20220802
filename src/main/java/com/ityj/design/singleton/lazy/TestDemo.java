package com.ityj.design.singleton.lazy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestDemo {
    public static void main(String[] args) {

        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance1 = LazySingleton.getInstance();
        System.out.println("instance  = " + instance);
        System.out.println("instance1 = " + instance1);

        StaticInnerClassLazySingleton instance3 = StaticInnerClassLazySingleton.getInstance();
        StaticInnerClassLazySingleton instance4 = StaticInnerClassLazySingleton.getInstance();
        System.out.println("instance3 = " + instance3);
        System.out.println("instance4 = " + instance4);

    }

    @Test
    public void testStream() {

        List<String> stringList = new ArrayList<>();
        /*if (CollectionUtils.isEmpty(stringList)) {
            System.out.println("null............");
            return;
        }*/
        //String s = stringList.stream().findFirst().get();
        //System.out.println("s = " + s);
        stringList.stream().findFirst().ifPresent( x -> {

            System.out.println("x = " + x);
        });
        String str = null;
        Optional.ofNullable(str).ifPresent(x -> {
            System.out.println("x = " + x);
        });


    }
}
