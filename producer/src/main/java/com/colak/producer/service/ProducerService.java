package com.colak.producer.service;

import com.colak.messages.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor
@Slf4j
public class ProducerService {

    private final ObjectMapper mapper;
    private final JmsTemplate jmsTemplate;

    @Value("${spring.artemis.embedded.queues}")
    private String artemisQueue;

    public void send(Message message) {
        try {
            String jmsMessage = mapper.writeValueAsString(message);
            log.info("Sending Message :: {}", jmsMessage);
            jmsTemplate.convertAndSend(artemisQueue, jmsMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
