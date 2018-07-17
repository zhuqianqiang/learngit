package com.zqq.product.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyReceiver {

    @RabbitListener(queuesToDeclare = @Queue("MyQueue"))
    public void process(String message) {
        log.info("receiver: {}",message);
    }
}
