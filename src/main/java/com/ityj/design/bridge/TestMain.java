package com.ityj.design.bridge;

public class TestMain {
    public static void main(String[] args) {
        OperationSystem os = new Windows(new RmvFile());
        os.playVideo("《Modern Family》");
    }
}
