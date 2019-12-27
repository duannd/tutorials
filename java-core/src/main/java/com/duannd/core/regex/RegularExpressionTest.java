package com.duannd.core.regex;

import java.util.regex.Pattern;

public class RegularExpressionTest {

    public static void main(String[] args) {
        patternMatcher();
        stringMatcher();
        throwMatcherException();
    }

    private static void throwMatcherException() {
        System.out.println("Compile 'a.b' throw exception" + "bbb".matches("*a.b")); // PatternSyntaxException
    }

    private static void stringMatcher() {
        System.out.println("bbb matches regex 'b.b' - " + "bbb".matches("b.b")); // true
        System.out.println("bbb matches regex 'a.b' - " + "bbb".matches("a.b")); // false
    }

    private static void patternMatcher() {
        Pattern pattern = Pattern.compile(".");
        System.out.println("a matches regex '.' - " + pattern.matcher("a").matches()); // true
        System.out.println("aa matches regex '.' - " + pattern.matcher("aa").matches()); // false
        System.out.println("ab matches regex '.b' - " + Pattern.matches(".b", "ab")); // true
    }

}
