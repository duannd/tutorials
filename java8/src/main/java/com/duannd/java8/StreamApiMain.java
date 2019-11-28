package com.duannd.java8;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class StreamApiMain {

    public static void main(String[] args) {
        Java8Utils.printHeader("Function and BiFunction");
        functionAndBiFunction();
    }

    private static void functionAndBiFunction() {
        Function<String, Long> convertLong = Long::parseLong;
        System.out.println(convertLong.apply("5"));
        BiFunction<String, String, People> peopleBiFunction = People::new;
        System.out.println(peopleBiFunction.apply("Duan", "Nguyen Dinh"));
        ToIntFunction<String> toIntFunction = Integer::parseInt;
        System.out.println("ToInt of 1: " + toIntFunction.applyAsInt("1"));
    }

    @Getter
    @Setter
    @NoArgsConstructor
    private static class People {
        private String fullName;

        private People(String firstName, String lastName) {
            this.fullName = firstName + " " + lastName;
        }

        @Override
        public String toString() {
            return fullName;
        }
    }

}
