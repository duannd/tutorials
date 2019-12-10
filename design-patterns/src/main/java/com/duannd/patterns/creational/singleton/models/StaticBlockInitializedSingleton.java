package com.duannd.patterns.creational.singleton.models;

public class StaticBlockInitializedSingleton {

    private static final StaticBlockInitializedSingleton instance;

    private StaticBlockInitializedSingleton() {

    }

    static {
        try {
            instance = new StaticBlockInitializedSingleton();
        } catch (Exception ex) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static StaticBlockInitializedSingleton getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "StaticBlockInitializedSingleton class";
    }
}
