package com.duannd.core.multithreading;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By duan.nd@senseinfosys.com at 1/17/2019 1:15 PM
 */
@Slf4j
class SynchronizedMethod {

    synchronized void doSomeThing() {
        try {
            Thread.sleep(5000);
            log.warn("Thread: {} is synchronized and slept 5000 ms", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
