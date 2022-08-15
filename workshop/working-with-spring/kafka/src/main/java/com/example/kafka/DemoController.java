package com.example.kafka;

import com.example.kafka.models.NewUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoProducer producer;

    @Autowired
    private DemoProducerWithPojo producerWithPojo;

    @Autowired
    private DemoProducerWithJson producerWithJson;

    @GetMapping("/produce/{message}")
    public void send(@PathVariable String message) {
        producer.sendMessage(message);
    }

    @GetMapping("/produce2/{name}")
    public void sendWithPojo(@PathVariable String name) throws JsonProcessingException {
        NewUser newUser = new NewUser();
        newUser.setName(name);
        producerWithPojo.sendMessage(newUser);
    }

    @GetMapping("/produce3/{name}")
    public void sendWithJson(@PathVariable String name) throws JsonProcessingException {
        NewUser newUser = new NewUser();
        newUser.setName(name);
        producerWithJson.sendMessage(newUser);
    }

}
