package com.ityj.design.builder.demo2;

public class BuilderTest {
    public static void main(String[] args) {
        Phone phone = Phone.builder()
                .battery("4600 mAh（典型值）")
                .chip("骁龙 888 4G")
                .os("HarmonyOS 2")
                .screen("OLED")
                .build();
        System.out.println("phone = " + phone);
    }
}
