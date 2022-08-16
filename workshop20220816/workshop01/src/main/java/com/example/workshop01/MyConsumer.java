package com.example.workshop01;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    @KafkaListener(topics = "demo.avro.topic.2")
    public void receiveData(User user) {
        System.out.println("Received message = " + user);
    }

}
