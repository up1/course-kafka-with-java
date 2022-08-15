package com.example.kafka.message;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

public class KafkaSendMessage {

    @Autowired
    private KafkaTemplate<String, String> template;

    public SendResult<String, String> send(String key, String message) {
        // Create message with key and payload
        ProducerRecord<String, String> record
                = new ProducerRecord<>("topic", key, message);
        // Send message
        try {
            SendResult<String, String> result = template.send(record).get();

            // Get metadata from result
            final RecordMetadata metadata = result.getRecordMetadata();
            System.out.printf("Sent record(key=%s value=%s " +
                            "meta(topic=%s,partition=%d, offset=%d)%n", record.key(),
                    record.value(), metadata.topic(), metadata.partition(),
                    metadata.offset());

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
