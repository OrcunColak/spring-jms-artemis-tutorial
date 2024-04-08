package com.colak.producer;

import com.colak.messages.Message;
import com.colak.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    private ProducerService producerService;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Message message = new Message();
        message.setEmail("johndoe@example.com");
        message.setName("JohnDoe");
        message.setWebsite("http://www.johndoe.com");

        producerService.send(message);
    }

    @Autowired
    public void setProducerService(ProducerService producerService) {
        this.producerService = producerService;
    }
}
