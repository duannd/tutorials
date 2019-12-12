package com.duannd.patterns.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryMain {

    private static final Logger log = LoggerFactory.getLogger(FactoryMain.class);

    public static void main(String[] args) {
        log.info("Factory Pattern start.......................................");
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
        System.out.println("Factory PC Config :: " + pc);
        System.out.println("Factory Server Config :: " + server);
    }

}
