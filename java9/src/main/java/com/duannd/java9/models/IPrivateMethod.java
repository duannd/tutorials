package com.duannd.java9.models;

@FunctionalInterface
public interface IPrivateMethod {

    String getMessage();

    static void publishMessages(String message) {
        logMessages(message);
    }

    default String publishName() {
        return getName();
    }

    private String getName() {
        return "Duan Nguyen";
    }

    private static void logMessages(String message) {
        System.out.println(message);
    }

}
