package com.duannd.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForeachMain {

    public static void main(String[] args) {
        System.out.println("----- Java 8 foreach -----");
        foreach();
        System.out.println("----- Foreach & change size of Collections -----");
        foreachAndChangeSizeOfCollection();
    }

    private static void foreach() {
        List<String> names = Arrays.asList("Duan", "Gate", "Trump", "Hang");
        names.forEach(System.out::println);
    }

    private static void foreachAndChangeSizeOfCollection() {
        List<String> names = new ArrayList<>(Arrays.asList("Duan", "Gate", "Trump", "Hang"));
        names.forEach(s -> {
            System.out.println(s);
            names.add("Test"); // throw java.util.ConcurrentModificationException
        });
    }

}
