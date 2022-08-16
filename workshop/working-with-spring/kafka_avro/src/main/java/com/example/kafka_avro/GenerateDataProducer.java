package com.example.kafka_avro;

import com.example.kafka_avro.models.NewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateDataProducer {

    @Autowired
    private DemoProducer producer;

    @Scheduled(fixedRateString = "1000")
    public void produceDataEverySecond() {
        NewUser newUser = new NewUser();
        int id = new Random().nextInt(100);
        newUser.setId(id);
        newUser.setName("Fake name " + id);
        producer.sendMessage(newUser);
    }

}
