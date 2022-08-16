package com.example.kafka_avro;

import com.example.kafka_avro.models.NewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DemoProducer {

    @Autowired
    private KafkaTemplate<String, NewUser> template;

    public void sendMessage(NewUser newUser) {
        template.send("demo.topic.avro.3", newUser);
    }

}
