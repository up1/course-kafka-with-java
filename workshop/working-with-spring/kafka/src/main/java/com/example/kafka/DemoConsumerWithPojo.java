package com.example.kafka;

import com.example.kafka.models.NewUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DemoConsumerWithPojo {

    @KafkaListener(topics="demo.topic.2")
    public void receiveData(String message) throws JsonProcessingException {
        System.out.println("Receive data => " + message);
        // Convert from json message to Java Object
        ObjectMapper objectMapper = new ObjectMapper();
        NewUser newUser = objectMapper.readValue(message, NewUser.class);
        System.out.println(newUser);
    }

}
