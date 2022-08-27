package com.ityj.design.bridge;

public class RmvFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("RmvFile.decode:" + fileName);
    }
}
