package com.duannd.java8.lambda;

/**
 * Created By duan.nd@senseinfosys.com at 11/29/2018 3:02 PM
 */
@FunctionalInterface
public interface ExampleFunctional {

    String sound();

    default String initSound() {
        return "Hello, ";
    }

    static boolean isTrue() {
        return true;
    }

}
