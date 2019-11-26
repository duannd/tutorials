package com.duannd.java11;

import java.util.stream.Collectors;

public class StringUtils {

    public static void main(String[] args) {
        System.out.println("---------- isBlank ----------");
        isBlank();
        System.out.println("---------- lines ----------");
        lines();
        System.out.println("---------- strip, stripLeading, stripTrailing ---------");
        strip();
        System.out.println("---------- repeat ----------");
        repeat();
    }

    private static void repeat() {
        System.out.println("Duan--".repeat(4));
    }

    private static void strip() {
        var name = "  Duan  ";
        System.out.println("myName:" + name + ":end");
        System.out.println("myName trim:" + name.trim() + ":end");
        System.out.println("start strip:" + name.strip() + ":end");
        System.out.println("start stripLeading:" + name.stripLeading() + ":end");
        System.out.println("start stripTrailing:" + name.stripTrailing() + ":end");
    }

    private static void lines() {
        var myName = "Nguyen\nDinh\nDuan\n";
        System.out.println(myName);
        var array = myName.lines().collect(Collectors.toList());
        System.out.println(array);
    }

    private static void isBlank() {
        System.out.println("".isBlank()); // true
        System.out.println("  ".isBlank()); // true
        System.out.println("Duan Nguyen".isBlank()); // false
        System.out.println("   DK".isBlank()); // false
    }

}
