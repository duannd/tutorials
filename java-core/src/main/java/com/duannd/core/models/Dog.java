package com.duannd.core.models;

/**
 * Created By ngdduan@gmail.com at 11/21/2018 10:55 AM
 */
public class Dog implements UnisexualAnimals {

    @Override
    public String birth() {
        return "Children";
    }

    @Override
    public String sound() {
        return "Woof woof";
    }

    @Override
    public String habitation() {
        return "shallow";
    }

    @Override
    public int noOfLegs() {
        return 4;
    }
}
