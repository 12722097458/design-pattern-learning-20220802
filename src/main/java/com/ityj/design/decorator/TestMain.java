package com.ityj.design.decorator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
*
*   装饰者模式   -- 手机壳装饰手机
*
* */
public class TestMain {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("")));

    }
}
