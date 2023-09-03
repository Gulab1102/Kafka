package com.example.kafka.kafkaproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.kafka.model.User;

@Service
public class KafkaProducer2 {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducer2.class);
	
	private KafkaTemplate< String,String> kafkaTemplate;
	

	public KafkaProducer2(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data) {
		LOGGER.info(String.format("Message sent %s",data));
		Message<User>message =MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC,"testing")
				.build();
		
		kafkaTemplate.send(message);
		LOGGER.info(String.format("Message sent %s",data));
				
	}
	
	

}
