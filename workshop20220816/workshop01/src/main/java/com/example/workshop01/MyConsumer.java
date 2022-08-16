package com.example.workshop01;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    @KafkaListener(topics = "demo.1.topic")
    public void receiveData(Employee employee) {
        System.out.println("Received message = " + employee);
    }

}
