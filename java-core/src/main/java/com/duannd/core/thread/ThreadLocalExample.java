package com.duannd.core.thread;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

/**
 * Created By ngdduan@gmail.com at 2019-02-22 00:47
 */
@Slf4j
public class ThreadLocalExample implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        var threadLocalExample = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(threadLocalExample, "" + i);
            Thread.sleep(2000);
            thread.start();
        }
    }

    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal
        .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm"));

    @Override
    public void run() {
        log.info("Default formatter pattern: {}", formatter.get().toPattern());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat());
        log.info("Edited formatter pattern: {}", formatter.get().toPattern());
    }

}
