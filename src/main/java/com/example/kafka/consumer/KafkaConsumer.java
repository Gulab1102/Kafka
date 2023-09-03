package com.example.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.kafkaproducer.KafkaProducer;
import com.example.kafka.model.User;

@Service
public class KafkaConsumer {

	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducer.class);
	
	@KafkaListener(topics = "user-topic", groupId = "mygroup")
	public void consume(String message) {
		LOGGER.info(String.format("Message received %s",message));
	}
	
	@KafkaListener(topics = "testing", groupId = "mygroup")
	public void consumejson(User message) {
		LOGGER.info(String.format("Message received %s",message));
	}
	
	
	
	@KafkaListener(topics = "realtime", groupId = "mygroup")
	public void consumeReal(String message) {
		LOGGER.info(String.format("Message received %s",message));
	}
}
