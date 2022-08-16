package com.example.kafka_avro;

import com.example.kafka_avro.models.NewUser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_PARTITION_ID;

@Service
public class DemoConsumer {

    @KafkaListener(topics = "demo.topic.avro.3")
    public void consumeMessage(NewUser newUser,
                               @Header(RECEIVED_PARTITION_ID) int partitionId) {
        System.out.printf("Consumer message from partition id = %d with data " +
                "%s", partitionId, newUser);
    }

}
