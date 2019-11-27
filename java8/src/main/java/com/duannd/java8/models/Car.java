package com.duannd.java8.models;

public class Car implements Vehicle {
    @Override
    public int getWheel() {
        return 4;
    }

    @Override
    public String getName() {
        return "Car";
    }
}
