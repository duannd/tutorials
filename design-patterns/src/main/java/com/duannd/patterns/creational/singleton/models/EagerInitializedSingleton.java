package com.duannd.patterns.creational.singleton.models;

public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {

    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "Eager Initialization class";
    }
}
