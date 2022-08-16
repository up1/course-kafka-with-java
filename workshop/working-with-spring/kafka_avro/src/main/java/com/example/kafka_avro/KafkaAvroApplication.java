package com.example.kafka_avro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaAvroApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaAvroApplication.class, args);
	}

}
