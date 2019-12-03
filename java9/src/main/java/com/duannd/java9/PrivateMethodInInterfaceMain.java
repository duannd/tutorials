package com.duannd.java9;

import com.duannd.java9.models.IPrivateMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.duannd.java9.Java9Utils.*;

public class PrivateMethodInInterfaceMain {

    private static final Logger log = LoggerFactory.getLogger(PrivateMethodInInterfaceMain.class);

    public static void main(String[] args) {
        printHeader("Private methods in Interfaces");
        privateMethodInInterfaces();
    }

    private static void privateMethodInInterfaces() {
        log.info("Private Method in Interface...");
        IPrivateMethod privateMethod = () -> "Hello, ";
        String message = privateMethod.getMessage() + privateMethod.publishName();
        IPrivateMethod.publishMessages(message);
    }

}
