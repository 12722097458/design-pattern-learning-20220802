package com.ityj.algorithm.test;

class ParkingSystem {

    private int big;
    private int medium;
    private int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    // carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示
    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                return this.big-- > 0;
            case 2:
                return this.medium-- > 0;
            case 3:
                return this.small-- > 0;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        ParkingSystem obj = new ParkingSystem(1, 1, 1);
        boolean param_1 = obj.addCar(3);
        System.out.println("param_1 = " + param_1);
    }
}
