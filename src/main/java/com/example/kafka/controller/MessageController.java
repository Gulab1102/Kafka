package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.kafkaproducer.KafkaProducer;
import com.example.kafka.kafkaproducer.KafkaProducerJson;
import com.example.kafka.model.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Autowired
	private KafkaProducerJson kafkaProducer2;
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody String message){
		kafkaProducer.sendMessage(message);
		
		return ResponseEntity.ok("Message send");
		
		
	}
	
	@PostMapping("/publishjson")
	public ResponseEntity<String> publishjson(@RequestBody User message){
		kafkaProducer2.sendMessage(message);
		
		return ResponseEntity.ok(" Json Message send");
		
		
	}

}
