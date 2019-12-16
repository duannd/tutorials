package com.duannd.patterns.creational.prototype;

public class PrototypePatternMain {

    public static void main(String[] args) throws CloneNotSupportedException {

        PrototypeUser user = new PrototypeUser(1, "Duan Nguyen");
        PrototypeUser clonedUser = user.clone();
        System.out.println(user);
        System.out.println(clonedUser);
    }

}
