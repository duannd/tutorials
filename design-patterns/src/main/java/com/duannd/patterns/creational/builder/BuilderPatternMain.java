package com.duannd.patterns.creational.builder;

import com.duannd.patterns.utils.DesignPatternUtils;

public class BuilderPatternMain {

    public static void main(String[] args) {
        DesignPatternUtils.printHeader("Builder Design Pattern");
        var student = new Student.StudentBuilder()
                .id("Duan-ID")
                .firstName("Duan")
                .lastName("Nguyen Dinh")
                .age(29)
                .address("190, Le Loi")
                .phoneNo("01234567890")
                .parent("My Parent")
                .averagePoint(9.9)
                .build();
        System.out.println(student);
    }

}
