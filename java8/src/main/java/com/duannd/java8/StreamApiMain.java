package com.duannd.java8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiMain {

    private static final Logger log = LoggerFactory.getLogger(StreamApiMain.class);
    private static final String[] ARRAY = new String[]{"Duan Nguyen", "Bill Gate", "Donal Trump", "Putin", "Jeff"};
    private static final List<String> NAMES = new ArrayList<>(Arrays.asList(ARRAY));

    public static void main(String[] args) {
        Java8Utils.printHeader("Function and BiFunction");
        functionAndBiFunction();

        Java8Utils.printHeader("Predicate and BiPredicate");
        predicateOrBiPredicate();

        Java8Utils.printHeader("Optional");
        optional();

        Java8Utils.printHeader("Creating Java Streams");
        createStreams();

        Java8Utils.printHeader("Converting Java Stream to Collection or Array");
        convertStream();

        Java8Utils.printHeader("Java Stream Intermediate Operations");
        intermediateOperations();

        Java8Utils.printHeader("Java Stream Terminal Operations");
        terminalOperations();
    }

    private static void terminalOperations() {
        log.info("Terminal Operations start............");
    }

    private static void intermediateOperations() {
        List<String> names = NAMES.stream()
            .filter(s -> s.contains("a"))
            .map(String::toUpperCase)
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
        System.out.println(names);
        Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("Pankaj", "Duan"),
            Arrays.asList("David", "Lisa"),
            Arrays.asList("Amit", "Nguyen"));
        Stream<String> concatStream = namesOriginalList.flatMap(Collection::stream);
        concatStream.forEach(System.out::println);
    }

    private static void convertStream() {
        Stream<String> stream = NAMES.stream();
        String[] names = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(names));
    }

    private static void createStreams() {
        Stream<String> stream = Stream.of(ARRAY);
        stream.parallel().forEach(System.out::println);
        System.out.println("--------------------");
        Stream<String> generateStream = Stream.generate(() -> "Duan Nguyen").limit(2);
        generateStream.forEach(System.out::println);
        System.out.println("--------------------");
        Stream<String> iterateStream = Stream.iterate("Bill Gate", i -> i.split(" ")[0]).limit(3);
        iterateStream.forEach(System.out::println);
        System.out.println("--------------------");
        IntStream intStream = "Duan Nguyen".chars();
        intStream.forEach(System.out::println);
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
