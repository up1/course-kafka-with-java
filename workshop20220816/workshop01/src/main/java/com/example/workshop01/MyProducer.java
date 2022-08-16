package com.example.workshop01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void tryToSend(String message) {
        kafkaTemplate.send("demo.1.topic", message);
    }

}
