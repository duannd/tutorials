package com.duannd.java8;

import com.duannd.java8.models.Car;
import com.duannd.java8.models.MotorBike;
import com.duannd.java8.models.Vehicle;

public class InterfaceMethodMain {

    public static void main(String[] args) {
        System.out.println("----- Interface static & default methods -----");
        newInterfaceMethods();
    }

    private static void newInterfaceMethods() {
        if (Vehicle.runnable()) {
            Vehicle car = new Car();
            System.out.println(car.message());
            Vehicle motorBike = new MotorBike();
            System.out.println(motorBike.message());
        }
    }

}
