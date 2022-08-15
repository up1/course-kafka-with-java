package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DemoConsumer {

    @KafkaListener(topics="demo.topic")
    public void receiveData(String message) {
        System.out.println("Receive data => " + message);
    }

}
