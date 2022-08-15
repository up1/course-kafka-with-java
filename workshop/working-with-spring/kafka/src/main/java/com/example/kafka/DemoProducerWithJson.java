package com.example.kafka;

import com.example.kafka.models.NewUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DemoProducerWithJson {
    @Autowired
    private KafkaTemplate<String, NewUser> kafkaTemplate;

    public void sendMessage(NewUser newUser) throws JsonProcessingException {
        this.kafkaTemplate.send("demo.topic.3", newUser);
    }
}
