package com.ityj.design.bridge;

public class AviFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("AviFile.decode:" + fileName);
    }
}
