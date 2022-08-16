package com.example.workshop01;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    @KafkaListener(topics = "demo.1.topic")
    public void receiveData(String message) {
        System.out.println("Received message = " + message);
    }

}
