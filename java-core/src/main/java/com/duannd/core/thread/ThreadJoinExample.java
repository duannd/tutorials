package com.duannd.core.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By ngdduan@gmail.com at 2/20/2019 10:37 AM
 */
@Slf4j
public class ThreadJoinExample {

    public static void main(String[] args) throws InterruptedException {
        var t1 = init("Thread 1 run", 10000);
        var t2 = init("Thread 2 run", 15000);
        t1.start();
        t1.join(3000); // will pause current thread (main) to t1 dead or after 3000 ms.
        // After 3000 ms => t2 start
        t2.start();
        t2.join(5000); // will pause current thread (main) to t2 dead or after 5000 ms.
        // after 3000 + 5000 ms will run below statement
        log.warn("After waiting 2000 ms");
        //let all threads finish execution before finishing main thread
        t1.join();
        t2.join();
        log.warn("All threads are dead, exiting main thread");
    }

    private static Thread init(String message, int millis) {
        return new Thread(() -> {
            try {
                log.info(message);
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
