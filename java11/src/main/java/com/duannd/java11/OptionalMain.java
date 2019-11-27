package com.duannd.java11;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class OptionalMain {

    private static final String NAME = "Duan";

    public static void main(String[] args) {
        System.out.println("----- Optional isEmpty -----");
        isEmpty(null);
        isEmpty(NAME);
        System.out.println("----- OptionalInt -----");
        optionalInt(0);
        optionalInt(1);
        System.out.println("----- OptionalLong -----");
        optionalLong(0);
        optionalLong(9);
    }

    private static void isEmpty(String value) {
        var optional2 = Optional.ofNullable(value);
        // isEmpty if value not present
        if (optional2.isEmpty()) {
            System.out.println(value + " is empty");
        }
        if (optional2.isPresent()) {
            System.out.println(value + " is present");
        }
    }

    private static void optionalInt(Integer value) {
        var opt = OptionalInt.of(value);
        var logMsg = String.format("Value: %d isEmpty: %s, isPresent: %s", opt.getAsInt(), opt.isEmpty(), opt.isPresent());
        System.out.println(logMsg);
    }

    private static void optionalLong(long value) {
        var opt = OptionalLong.of(value);
        var logMsg = String.format("Value: %d isEmpty: %s, isPresent: %s", opt.getAsLong(), opt.isEmpty(), opt.isPresent());
        System.out.println(logMsg);
    }

}
