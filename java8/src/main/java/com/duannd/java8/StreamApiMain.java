package com.duannd.java8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

public class StreamApiMain {

    private static final List<String> NAMES = new ArrayList<>(Arrays
            .asList("Duan Nguyen", "Bill Gate", "Tap Can Binh", "Donal Trump", "Putin", "Jeff"));

    public static void main(String[] args) {
        Java8Utils.printHeader("Function and BiFunction");
        functionAndBiFunction();

        Java8Utils.printHeader("Predicate and BiPredicate");
        predicateOrBiPredicate();

        Java8Utils.printHeader("Optional");
        optional();
    }

    private static void optional() {
        Optional<List<String>> optional = Optional.of(NAMES);
        String allName = optional.map(Object::toString).orElse(null);
        System.out.println(allName);
    }

    private static void predicateOrBiPredicate() {
        Predicate<People> isLegalFullName = people -> people.fullName != null && !people.fullName.isEmpty();
        BiPredicate<People, String> biPredicate = (people, s) -> s != null && s.equalsIgnoreCase(people.fullName);
        List<People> isLegalPeople = NAMES
                .stream()
                .map(People::new)
                .filter(isLegalFullName)
                .filter(people -> biPredicate.test(people, "duan nguyen"))
                .collect(Collectors.toList());
        System.out.println(isLegalPeople);
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
    @AllArgsConstructor
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
