package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.kafka.kafkaproducer.KafkaProduceRealTime;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}
	
	
   @Autowired
	private KafkaProduceRealTime kafkaProduceRealTime;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		kafkaProduceRealTime.sendMessage();
		
	}

}
