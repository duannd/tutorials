package com.duannd.java11;

public class LocalVariableSyntaxMain {

    public static void main(String[] args) {
        System.out.println("----- Local Variable Syntax -----");
        localVariableSyntax();
    }

    private static void localVariableSyntax() {
        ILocalVariableSyntax syntax = (s1, s2) -> s1 + s2 + 1;
        System.out.println(syntax.plusOne(5, 9));
    }

}
