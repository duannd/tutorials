package com.duannd.java9;

public class Java9Utils {

    public static final String[] NAMES = new String[]{"Duan Nguyen", "Bill Gate", "Trump", "Kim Yong Un", "Putin"};

    private Java9Utils() {

    }

    public static void printHeader(String header) {
        System.out.println(String.format("------------------------------- %s -------------------------------", header));
    }

}
