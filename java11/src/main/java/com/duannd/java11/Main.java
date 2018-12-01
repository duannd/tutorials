package com.duannd.java11;

/**
 * Created By ngdduan@gmail.com at 11/29/2018 2:34 PM
 */
public class Main {

    public static void main(String args[]) {
        testVar();
    }

    private static void testVar() {
        var a = Integer.valueOf(1);
        if (a != null)
            System.out.println(a);

        System.out.println("OK, finish add jdk11 to project");
    }

}
