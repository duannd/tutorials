package com.duannd.java8.models;

public class MotorBike implements Vehicle {

    @Override
    public int getWheel() {
        return 2;
    }

    @Override
    public String getName() {
        return "Motor Bike";
    }
}
