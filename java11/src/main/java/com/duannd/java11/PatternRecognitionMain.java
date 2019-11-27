package com.duannd.java11;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PatternRecognitionMain {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";

    public static void main(String[] args) {
        System.out.println("----- Pattern Recognition -----");
        asMatchPredicate();
    }

    private static void asMatchPredicate() {
        var pattern = Pattern.compile("aba").asPredicate();
        System.out.println(pattern.test("aaaaa"));
        System.out.println(pattern.test("a aba"));
        System.out.println(pattern.test("aba a"));
        System.out.println(pattern.test("aabb"));

        var pattern2 = Pattern.compile(EMAIL_PATTERN).asMatchPredicate();
        Stream.of("jondoe@gmail.com", "duan+01@mido.com", "duannd.*@gmail.com", "24243", "(&*^^^&^")
                .filter(pattern2)
                .forEach(System.out::println);
    }

}
