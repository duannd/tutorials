package com.duannd.patterns.creational.singleton.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadSafeSingleton {

    private static final Logger log = LoggerFactory.getLogger(ThreadSafeSingleton.class);
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {

    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    log.info("Initial Thread Safe Singleton");
                    instance = new ThreadSafeSingleton();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    public void log() {
        log.info("Log Thread safe singleton to check thread");
    }

    @Override
    public String toString() {
        return "ThreadSafeSingleton class";
    }
}
