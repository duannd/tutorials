package com.duannd.springboot.messaging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By duan.nd@senseinfosys.com at 1/14/2019 10:19 AM
 */
@RestController
@RequestMapping("activeMQ")
public class ActiveMQController {

    private ActiveMQProducer activeMQProducer;

    @Autowired
    public ActiveMQController(ActiveMQProducer activeMQProducer) {
        this.activeMQProducer = activeMQProducer;
    }

    @PostMapping("send")
    public void sendMessage(@RequestBody String message) {
        activeMQProducer.sender(message);
    }

}
