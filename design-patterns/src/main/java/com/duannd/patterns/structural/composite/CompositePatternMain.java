package com.duannd.patterns.structural.composite;

import com.duannd.patterns.utils.DesignPatternUtils;

public class CompositePatternMain {

    public static void main(String[] args) {
        DesignPatternUtils.printHeader("Composite Design Pattern");
        Shape tri = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(tri1);
        drawing.add(tri1);
        drawing.add(cir);

        drawing.draw("Red");

        drawing.clear();

        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Green");
    }
}
