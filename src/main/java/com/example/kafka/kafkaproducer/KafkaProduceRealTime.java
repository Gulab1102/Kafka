package com.example.kafka.kafkaproducer;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import com.launchdarkly.eventsource.background.BackgroundEventSource.Builder;

@Service
public class KafkaProduceRealTime {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProduceRealTime.class);
	
	
	
	private KafkaTemplate< String,String> kafkaTemplate;
	

	public KafkaProduceRealTime(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() throws InterruptedException {
		
		BackgroundEventHandler back=new WikimediaChangesHandler(kafkaTemplate, "realtime");
		URI url=URI.create("https://stream.wikimedia.org/v2/stream/recentchange");
		
		
		EventSource.Builder evBuilder=new EventSource.Builder(url);
		
	  BackgroundEventSource.Builder builder =new BackgroundEventSource.Builder(back,evBuilder);
	  
	  BackgroundEventSource eventSource=builder.build();
	  
	  eventSource.start();
	  
	  TimeUnit.MINUTES.sleep(10);
		
		//Builder builder=new Builder(back, );
		
	}
	
	

}
