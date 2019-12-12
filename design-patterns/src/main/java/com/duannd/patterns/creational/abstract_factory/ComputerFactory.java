package com.duannd.patterns.creational.abstract_factory;

import com.duannd.patterns.creational.factory.Computer;

public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }

}
