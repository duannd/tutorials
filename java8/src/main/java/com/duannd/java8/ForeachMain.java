package com.duannd.java8;

import java.util.Arrays;
import java.util.List;

public class ForeachMain {

    public static void main(String[] args) {
        System.out.println("----- Java 8 foreach -----");
        foreach();
    }

    private static void foreach() {
        List<String> names = Arrays.asList("Duan", "Gate", "Trump", "Hang");
        names.forEach(System.out::println);
    }

}
