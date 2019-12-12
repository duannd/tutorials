package com.duannd.patterns.creational.singleton.models;

public enum EnumSingleton {

    INSTANCE;

    public static void log() {
        System.out.println("Enum Singleton :: log");
    }

}
