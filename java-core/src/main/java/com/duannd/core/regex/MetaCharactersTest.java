package com.duannd.core.regex;

import static com.duannd.core.regex.CommonMatchingSymbolsTest.print;

public class MetaCharactersTest {
    public static void main(String[] args) {
        // \d	Any digits, short of [0-9]
        anyDigits();
        // \D	Any non-digit, short for [^0-9]
        anyNonDigits();
        // \s	Any whitespace character, short for [\t\n\x0B\f\r]
        anyWhitespaceCharacter();
        // \S	Any non-whitespace character, short for [^\s]
        anyNonWhitespaceCharacter();
        // \w	Any word character, short for [a-zA-Z_0-9]
        anyWordCharacter();
        // \W	Any non-word character, short for [^\w]
        anyNonWordCharacter();
        // \b	A word boundary
        aWordBoundary();
    }

    private static void aWordBoundary() {
        String regex = "\b";
        print("A word boundary", regex, " ");
        print("A word boundary", regex, "Java.");
        print("A word boundary", regex, ",");
        print("A word boundary", regex, "!");
        print("A word boundary", regex, ".");
        print("A word boundary", regex, "[");
        print("A word boundary", regex, "]");
        print("A word boundary", regex, ";");
        print("A word boundary", regex, "(");
        print("A word boundary", regex, "{");
    }

    private static void anyNonWordCharacter() {
        String regex = "\\W";
        print("Any non-word character, short for [^\\w]", regex, "a"); // false
        print("Any non-word character, short for [^\\w]", regex, "A"); // false
        print("Any non-word character, short for [^\\w]", regex, "0"); // false
        print("Any non-word character, short for [^\\w]", regex, "_"); // false
        print("Any non-word character, short for [^\\w]", regex, "@"); // true
        print("Any non-word character, short for [^\\w]", regex, "aa"); // false
    }

    private static void anyWordCharacter() {
        String regex = "\\w";
        print("Any word character, short for [a-zA-Z_0-9]", regex, "a"); // true
        print("Any word character, short for [a-zA-Z_0-9]", regex, "A"); // true
        print("Any word character, short for [a-zA-Z_0-9]", regex, "0"); // true
        print("Any word character, short for [a-zA-Z_0-9]", regex, "_"); // true
        print("Any word character, short for [a-zA-Z_0-9]", regex, "@"); // false
        print("Any word character, short for [a-zA-Z_0-9]", regex, "aa"); // false
    }

    private static void anyNonWhitespaceCharacter() {
        String regex = "\\S";
        print("Any non-whitespace character, short for [^\\s]", regex, "a"); //true
        print("Any non-whitespace character, short for [^\\s]", regex, "0"); //true
        print("Any non-whitespace character, short for [^\\s]", regex, " "); //false
    }

    private static void anyWhitespaceCharacter() {
        String regex = "\\s";
        print("Any whitespace character, short for [\tx0B\f]", regex, " "); // true
        print("Any whitespace character, short for [\tx0B\f]", regex, "a"); // false
        print("Any whitespace character, short for [\tx0B\f]", regex, "1"); // false
    }

    private static void anyNonDigits() {
        String regex = "\\D";
        print("Any non-digit, short for [^0-9]", regex, "a"); // true
        print("Any non-digit, short for [^0-9]", regex, "@"); // true
        print("Any non-digit, short for [^0-9]", regex, "a@"); // false
        print("Any non-digit, short for [^0-9]", regex, "1"); // false
        print("Any non-digit, short for [^0-9]", regex, "8"); // false
    }

    private static void anyDigits() {
        String regex = "\\d";
        print("Any digits, short of [0-9]", regex, "0"); // true
        print("Any digits, short of [0-9]", regex, "9"); // true
        print("Any digits, short of [0-9]", regex, "a"); // false
        print("Any digits, short of [0-9]", regex, "#"); // false
    }
}
