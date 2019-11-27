package com.duannd.java8.models;

public interface Vehicle {

    static boolean runnable() {
        return true;
    }

    default String message() {
        return String.format("%s have %s wheel.", getName(), getWheel());
    }

    int getWheel();

    String getName();

}
