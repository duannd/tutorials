package com.duannd.core.thread;

import com.duannd.core.models.Message;
import lombok.extern.slf4j.Slf4j;

/**
 * Created By duan.nd@senseinfosys.com at 2/20/2019 3:24 PM
 */
@Slf4j
public class Notifier implements Runnable {

    private final Message msg;

    Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        log.info(name + " started");
        try {
            Thread.sleep(5000);
            synchronized (msg) {
                msg.setMsg(name + " Notifier work done");
                //msg.notify();
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
