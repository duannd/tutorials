package com.duannd.java11.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created By ngdduan@gmail.com at 12/1/18 12:48 PM
 */
public class LocalVariableTypeInference {

    public static void main(String args[]) {

        /* inference correct*/
        var java = "Oracle JDK";
        var version = 11;
        System.out.println(java + " " + version);

        /*incompatible infer*/
//         java = version;

        /*final keyword: Cannot assign a value to final variable*/
        final var text = "Hello World";
//        text = java;
        System.out.println(text);

        /* Cannot infer type without initializer */
//        var a;
//        var nothing = null;
//        var lambda = () -> System.out.println("Pity!");
//        var method = this::someMethod;

        /* infer type in forEach */
        var myList = new ArrayList<Map<String, List<Integer>>>();
        myList.add(Collections.singletonMap("test", Collections.singletonList(11)));
        for (var current : myList) {
            // current is infer to type: Map<String, List<Integer>>
            System.out.println(current);
        }

        /* Infer type in lambda */
        myList.forEach((var ele) -> {
            if (ele.containsKey("test"))
                System.out.println("Perfect test");
        });

        Predicate<String> predicate = "test"::equals;
        System.out.println(predicate.test("test"));
    }

}
