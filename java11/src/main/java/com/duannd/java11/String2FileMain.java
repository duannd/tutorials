package com.duannd.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class String2FileMain {

    private static final String FILE_NAME = "profile.txt";
    private static final String FULL_NAME = "Duan Nguyen Dinh";

    public static void main(String[] args) throws Exception {
        System.out.println("----- String to File -----");
        string2File();
        System.out.println("----- File to String -----");
        fileToString();
    }

    private static void string2File() throws IOException {
        Path path = Paths.get("./", FILE_NAME);
        System.out.println(path);
        Files.deleteIfExists(path);
        Path file = Files.createFile(path);
        Path writeString = Files.writeString(file, FULL_NAME);
        System.out.println(writeString);
    }

    private static void fileToString() throws IOException {
        Path path = Paths.get("./", FILE_NAME);
        System.out.println(path);
        String content = Files.readString(path);
        System.out.println(content);
    }

}
