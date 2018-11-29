package com.duannd.java8.lambda;

/**
 * Created By duan.nd@senseinfosys.com at 11/29/2018 2:53 PM
 */
public class LambdaExpression {

    public static void main(String args[]) {
        // Lambda with functionInterface
        functionalInterface();
    }

    private static void functionalInterface() {
        ExampleFunctional functional = () -> "World";
        System.out.println(functional.initSound() + functional.sound()
                + ", allow static method: " + ExampleFunctional.isTrue());
    }

}
