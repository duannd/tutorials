package com.duannd.java8;

import com.duannd.java8.lambda.ExampleFunctional;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaExpressionMain {

    public static void main(String[] args) {
        System.out.println("----- Functional Interfaces -----");
        functionalInterfaces();

        System.out.println("----- Sequential and Parallel Execution Support -----");
        System.out.println("1 is prime? " + isPrime(1));
        System.out.println("7 is prime? " + isPrime(7));
        System.out.println("15 is prime? " + isPrime(15));
        System.out.println("29 is prime? " + isPrime(29));

        List<Integer> numbers = Stream.of(1, 3, 6, 9, 10, 11, 15).collect(Collectors.toList());
        System.out.println("----- Passing Behaviors into methods ------");
        System.out.println(sumWithCondition(numbers, num -> true));
        System.out.println(sumWithCondition(numbers, num -> num % 2 == 0));
        System.out.println(sumWithCondition(numbers, num -> num > 10));

        System.out.println("----- Higher Efficiency with Laziness -----");
        System.out.println(findSquareOfMaxOdd(numbers));
    }

    private static int findSquareOfMaxOdd(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 1)
                .filter(num -> num > 3)
                .filter(num -> num < 11)
                .max(Comparator.naturalOrder())
                .map(num -> num * num)
                .get();
    }

    private static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .mapToInt(num -> num)
                .sum();
    }

    // Example about "Sequential and Parallel Execution Support" benefit of Lambda Expression (Stream API).
    private static boolean isPrime(final int number) {
        IntPredicate isDivisible = index -> number % index == 0;
        return number > 1 && IntStream.range(2, number / 2).noneMatch(isDivisible);
    }

    // example about functional interfaces in Java 08.
    private static void functionalInterfaces() {
        ExampleFunctional functional = () -> "Meow Meow";
        System.out.println(functional.initSound() + functional.sound());
    }


}
