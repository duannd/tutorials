package com.duannd.core.regex;

import static com.duannd.core.regex.CommonMatchingSymbolsTest.print;

public class QuantifiersTest {

    public static void main(String[] args) {
        // x?	x occurs once or not at all
        occursOnceOrNotAtAll();
        // X*	X occurs zero or more times
        occursZeroOrMoreTimes();
        // X+	X occurs one or more times
        occursOneOrMoreTimes();
        // X{n}	X occurs exactly n times
        occursExactlyNTimes();
        // X{n,}	X occurs n or more times
        occursNOrMoreTimes();
        // X{n,m}	X occurs at least n times but not more than m times
        occursFromN2MTimes();
    }

    private static void occursFromN2MTimes() {
        String regex = "[0-9]{2,4}"; // least 2 to 4 times
        print("X occurs at least n times but not more than m times", regex, "12");// true
        print("X occurs at least n times but not more than m times", regex, "123");// true
        print("X occurs at least n times but not more than m times", regex, "1234");// true
        print("X occurs at least n times but not more than m times", regex, "1");// false
        print("X occurs at least n times but not more than m times", regex, "12345");// false
        print("X occurs at least n times but not more than m times", regex, "aa");// false
        print("X occurs at least n times but not more than m times", regex, "abcd");// false
        print("X occurs at least n times but not more than m times", regex, "");// false
    }

    private static void occursNOrMoreTimes() {
        String regex = "[0-9]{1,}"; // least 1 time.
        print("X occurs 1 or more times", regex, "1"); // true
        print("X occurs 1 or more times", regex, "1232423"); // true
        print("X occurs 1 or more times", regex, "123242334535345345345345345453453"); // true
        print("X occurs 1 or more times", regex, "1â232423"); // false
        print("X occurs 1 or more times", regex, "a"); // false
    }

    private static void occursExactlyNTimes() {
        String regex = "[0-9]{4}";
        print("X occurs exactly n times", regex, "0123"); // true
        print("X occurs exactly n times", regex, "2019"); // true
        print("X occurs exactly n times", regex, "abcd"); // false
        print("X occurs exactly n times", regex, "1"); // false
        print("X occurs exactly n times", regex, "12"); // false
        print("X occurs exactly n times", regex, "123"); // false
        print("X occurs exactly n times", regex, "12345"); // false
        print("X occurs exactly n times", regex, ""); // false
        print("X occurs exactly n times", regex, "aa"); // false
    }

    private static void occursOneOrMoreTimes() {
        String regex = "[0-9]+";
        print("X occurs one or more times", regex, "1"); // true
        print("X occurs one or more times", regex, "12"); // true
        print("X occurs one or more times", regex, "123"); // true
        print("X occurs one or more times", regex, ""); // false
        print("X occurs one or more times", regex, "a"); // false
        print("X occurs one or more times", regex, "1a"); // false
        print("X occurs one or more times", regex, "abc"); // false
    }

    private static void occursZeroOrMoreTimes() {
        String regex = "[0-9]*";
        print("X occurs zero or more times", regex, "2"); // true
        print("X occurs zero or more times", regex, ""); // true
        print("X occurs zero or more times", regex, " "); // false
        print("X occurs zero or more times", regex, "22"); // true
        print("X occurs zero or more times", regex, "a"); // false
        print("X occurs zero or more times", regex, "2a"); // false
        print("X occurs zero or more times", regex, "aa"); // false
        print("X occurs zero or more times", regex, "2a2"); // false
    }

    private static void occursOnceOrNotAtAll() {
        String regex = "[0-9]?"; // \d?
        print("x occurs once or not at all", regex, "1"); // true
        print("x occurs once or not at all", regex, ""); // true
        print("x occurs once or not at all", regex, " "); // false
        print("x occurs once or not at all", regex, "ab"); // false
        print("x occurs once or not at all", regex, "1a"); // false
        print("x occurs once or not at all", regex, "12"); // false
        print("x occurs once or not at all", regex, "1a1"); // false
    }

}
