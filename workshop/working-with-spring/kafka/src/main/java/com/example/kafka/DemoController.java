package com.example.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoProducer producer;

    @GetMapping("/produce/{message}")
    public void send(@PathVariable String message) {
        producer.sendMessage(message);
    }

}
