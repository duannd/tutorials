package com.duannd.springboot.messaging.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created By duan.nd@senseinfosys.com at 1/17/2019 3:05 PM
 */
@Slf4j
@Component
public class ActiveMQConsumer {

    @JmsListener(id = "ActiveMQConsumer-local-sender", destination = "local-sender")
    public void receiveFromSender(String msg) {
        log.info("Receive msg: {} from local-sender", msg);
        doSomething();
    }

    @JmsListener(id = "ActiveMQConsumer-local-receiver", destination = "local-receiver")
    public void receive(String msg) {
        log.info("Receive msg: {} from local-receiver", msg);
        doSomething();
    }

    private void doSomething() {
        try {
            Thread.sleep(60000);
            log.warn("After sleeping of {}", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
