package com.example.kafka;

import com.example.kafka.models.NewUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class DemoConsumerWithJson {

    @KafkaListener(topics="demo.topic.3")
    public void receiveData(NewUser newUser){
        System.out.println(newUser);
    }

}
