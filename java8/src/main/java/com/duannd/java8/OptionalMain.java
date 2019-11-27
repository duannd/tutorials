package com.duannd.java8;

import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {
        // Step 1: Initial optional
        Optional<String> optional = initial();
        // Step 2: check isPresent
        present(optional);
        // Step 3: orElse
        System.out.println(orElse(optional));
        // Step 3.1 OrGet
        System.out.println(orElseGet(optional));
        // Step 4: orThrow
        orThrow(optional);
    }

    private static String orElseGet(Optional<String> optional) {
        return optional.orElseGet(() -> "Duan ND GET");
    }

    private static void orThrow(Optional<String> optional) {
        optional.orElseThrow(() -> new RuntimeException(""));
    }

    private static String orElse(Optional<String> optional) {
        return optional.orElse("DuanND");
    }

    private static void present(Optional<String> opt) {
        if (opt.isPresent()) {
            System.out.println("Opt Value is not null");
        } else {
            System.out.println("Opt Value is null");
        }
    }

    private static Optional<String> initial() {
        return Optional.empty();
    }

}
