package com.ityj.design.builder.demo;

public class BuilderTest {
    public static void main(String[] args) {
        Phone phone = new Phone.PhoneBuilder()
                .battery("视频播放最长可达 17 小时")
                .chip("A14 仿生芯片")
                .os("IOS")
                .screen("超视网膜 XDR 显示屏")
                .newPhone();
        System.out.println("phone = " + phone);
    }
}
