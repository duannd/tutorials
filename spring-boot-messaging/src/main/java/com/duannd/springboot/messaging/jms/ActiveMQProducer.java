package com.duannd.springboot.messaging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created By duan.nd@senseinfosys.com at 1/14/2019 10:49 AM
 */
@Component
public class ActiveMQProducer {

    @Value("${log.service.receiver.queue.name}")
    private String loggerQueue;

    private JmsTemplate jmsTemplate;

    @Autowired
    public ActiveMQProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    void sender(String message) {
        jmsTemplate.convertAndSend(loggerQueue, message);
    }

}
