package com.duannd.patterns.creational.abstract_factory;

import com.duannd.patterns.creational.factory.Computer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractFactoryMain {

    private static final Logger log = LoggerFactory.getLogger(AbstractFactoryMain.class);

    public static void main(String[] args) {
        log.info("Abstract Factory Main start............................................");
        ComputerAbstractFactory pcFactory = new PCFactory("2 GB", "500 GB", "2.4 GHz");
        ComputerAbstractFactory serverFactory = new ServerFactory("16 GB", "1 TB", "2.9 GHz");
        Computer pc = ComputerFactory.getComputer(pcFactory);
        Computer server = ComputerFactory.getComputer(serverFactory);
        System.out.println(pc);
        System.out.println(server);
    }

}
