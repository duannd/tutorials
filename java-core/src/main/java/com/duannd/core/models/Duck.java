package com.duannd.core.models;

/**
 * Created By ngdduan@gmail.com at 11/21/2018 10:58 AM
 */
public class Duck implements UnisexualAnimals {

    @Override
    public String birth() {
        return "eggs";
    }

    @Override
    public String sound() {
        return "Quack quack";
    }

    @Override
    public String habitation() {
        return "shallow & water";
    }

    @Override
    public int noOfLegs() {
        return 2;
    }
}
