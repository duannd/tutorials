package com.duannd.test;

import com.duannd.models.Progression;
import com.duannd.models.sub.ArithmeticProgression;

public class ProgressionTest {

    public static void main(String[] args) {
        Progression prog;
        // test ArithmeticProgression
        System.out.print("Arithmetic progression with default increment: ");
        prog = new ArithmeticProgression( );
        prog.printProgression(10);
        System.out.print("Arithmetic progression with increment 5: ");
        prog = new ArithmeticProgression(5);
        prog.printProgression(10);
        System.out.print("Arithmetic progression with start 2: ");
        prog = new ArithmeticProgression(5, 2);
        prog.printProgression(10);
        // Test GeometricProgression
    }

}
