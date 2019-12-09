package com.duannd.java9;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalImprovementMain {

    public static void main(String[] args) {
        Java9Utils.printHeader("Java SE 9: Optional stream() Method");
        streamExamples();
        Java9Utils.printHeader("Java SE 9: Optional ifPresentOrElse() Method");
        ifPresentOrElse();
    }

    private static void ifPresentOrElse() {
        Optional<Integer> optional = Optional.empty();
        optional.ifPresentOrElse(System.out::println, () -> {
            System.out.println("Optional is empty");
        });
        System.out.println(optional.or(() -> Optional.of(1)).get());
    }

    private static void streamExamples() {
        // stream
        Optional<Integer> integer = Optional.of(2);
        Stream<Integer> stream = integer.stream();
        stream.forEach(System.out::println);

    }

}
