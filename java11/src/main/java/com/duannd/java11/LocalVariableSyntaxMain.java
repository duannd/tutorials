package com.duannd.java11;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.function.Function;

public class LocalVariableSyntaxMain {

    public static void main(String[] args) {
        System.out.println("----- Local Variable Syntax -----");
        localVariableSyntax();
        System.out.println("----- Lambda & FunctionalInterface -----");
        getFullName();
    }

    private static void localVariableSyntax() {
        ILocalVariableSyntax syntax = (s1, s2) -> s1 + s2 + 1;
        System.out.println(syntax.plusOne(5, 9));
    }

    private static void getFullName() {
        Function<String, Student> function = (@NotNull var firstName) -> {
            String fullName = "Hello, " + firstName;
            return new Student(fullName);
        };
        System.out.println(function.apply("DuanND"));
        System.out.println(function.apply(null));
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    private static class Student {

        @NotNull
        private String fullName;

    }

}
