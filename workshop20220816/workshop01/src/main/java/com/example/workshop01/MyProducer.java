package com.example.workshop01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void tryToSend(String name) {
        User user = new User();
        user.setName(name);
        kafkaTemplate.send("demo.avro.topic.2", user);
    }

}
