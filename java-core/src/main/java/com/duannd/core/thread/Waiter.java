package com.duannd.core.thread;

import com.duannd.core.models.Message;
import lombok.extern.slf4j.Slf4j;

/**
 * Created By ngdduan@gmail.com at 2/20/2019 2:54 PM
 */
@Slf4j
public class Waiter implements Runnable {

    private final Message msg;

    Waiter(Message m) {
        this.msg = m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            log.info("{}: before waiting message: {}", name, msg.getMsg());
            try {
                log.info(name + " waiting to get notified at time:" + System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info(name + " waiter thread got notified at time:" + System.currentTimeMillis());
            //process the message now
            log.info(name + " processed: " + msg.getMsg());
        }
    }
}
