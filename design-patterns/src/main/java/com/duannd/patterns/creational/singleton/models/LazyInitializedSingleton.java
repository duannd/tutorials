package com.duannd.patterns.creational.singleton.models;

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {

    }

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            System.out.println("Initial LazyInitializedSingleton");
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "LazyInitializedSingleton class";
    }
}
