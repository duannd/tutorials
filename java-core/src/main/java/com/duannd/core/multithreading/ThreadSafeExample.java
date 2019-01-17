package com.duannd.core.multithreading;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By duan.nd@senseinfosys.com at 1/17/2019 1:14 PM
 */
@Slf4j
public class ThreadSafeExample {

    public static void main(String[] args) {
        // Test synchronized keyword lock object
        synchronizedMethod();
    }

    private static void synchronizedMethod() {
        var methodObj = new SynchronizedMethod();
        new Thread(() -> {
            log.info("Run Thread one start...");
            methodObj.doSomeThing();
        }).start();
        new Thread(() -> {
            log.info("Run Thread Two start...");
            methodObj.doSomeThing();
        }).start();
        new Thread(() -> {
            log.info("Run Thread Three start...");
            methodObj.doSomeThing();
        }).start();
    }

}
