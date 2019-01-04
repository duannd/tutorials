package com.duannd.core.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created By ngdduan@gmail.com at 1/1/19 1:08 AM
 */
public class ThreadExample extends Thread {

    private static final Logger log = LoggerFactory.getLogger(ThreadExample.class);

    public static void main(String[] args) {
        log.info("Multi Threading example...");
        // TODO 1. two ways to create a thread
        for (int i = 0; i < 1; i++) {
            initByImplementRunnable(i);
        }
        initByExtendThread();

        // TODO 2. Thread.sleep
        sleep(1);

        // TODO 3. Thread Join
        joinThread();
    }

    private static void initByImplementRunnable(final int id) {
        Runnable runnable = () -> {
            log.info("Init Thread by implements Runnable interface id: {}", id);
            sleep(2000);
        };
        var thread = new Thread(runnable);
        thread.start();
    }

    private static void initByExtendThread() {
        var thread = new ThreadExample();
        thread.start();
    }

    @Override
    public void run() {
        log.info("Init Thread by extend Thread class");
        sleep(3000);
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void joinThread() {


    }
}
