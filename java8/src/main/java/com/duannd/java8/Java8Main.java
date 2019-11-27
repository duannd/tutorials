package com.duannd.java8;

import java.io.File;
import java.io.FileFilter;

/**
 * Created By ngdduan@gmail.com at 11/29/2018 2:52 PM
 */
public class Java8Main {

    public static void main(String[] args) {
        methodReference();
    }

    private static void methodReference() {
        System.out.println("Method Reference");
        FileFilter fileFilter = Java8Main::testReferenceMethod;
        System.out.println(fileFilter.accept(new File("Hello test")));
    }

    private static boolean testReferenceMethod(File file) {
        System.out.println("File Name: " + file.getName());
        return true;
    }

}
