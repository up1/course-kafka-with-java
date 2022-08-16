package com.example.workshop01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private MyProducer producer;

    @GetMapping("/send/{name}")
    public void send(@PathVariable String name) {
        producer.tryToSend(name);
    }

}
