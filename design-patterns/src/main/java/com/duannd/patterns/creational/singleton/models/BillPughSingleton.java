package com.duannd.patterns.creational.singleton.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BillPughSingleton {

    private static final Logger log = LoggerFactory.getLogger(BillPughSingleton.class);

    private BillPughSingleton() {

    }

    private static class SingletonHelper {

        private static final BillPughSingleton INSTANCE;

        static { //
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Initial Bill Pugh Singleton instance");
            INSTANCE = new BillPughSingleton();
        }
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void log() {
        log.info("Log Bill Push singleton to check thread name {}", Thread.currentThread().getName());
    }

}
