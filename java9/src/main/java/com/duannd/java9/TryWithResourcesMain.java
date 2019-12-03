package com.duannd.java9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesMain {

    public static void main(String[] args) throws IOException {
        Java9Utils.printHeader("Java SE 9: Try-With-Resources Improvements");
        tryWithResources();
    }

    private static void tryWithResources() throws IOException {
        String filePath = TryWithResourcesMain.class.getResource("/test.txt").getFile();
        System.out.println(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        try (reader) {
            reader.lines().forEach(System.out::println);
        }
    }

}
