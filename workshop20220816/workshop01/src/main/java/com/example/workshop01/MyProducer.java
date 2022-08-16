package com.example.workshop01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    public void tryToSend(String name) {
        Employee employee = new Employee();
        employee.setName(name);
        kafkaTemplate.send("demo.2.topic", employee);
    }

}
