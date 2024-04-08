package com.colak.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {

    @JmsListener(destination = "${spring.artemis.embedded.queues}")
    public void messageListener(String message) {
        log.info("Message received, {}", message);
    }
}
