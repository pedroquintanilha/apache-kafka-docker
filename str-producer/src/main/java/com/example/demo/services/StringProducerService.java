package com.example.demo.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Service
public class StringProducerService {
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final Logger log = LogManager.getLogger(StringProducerService.class);
	
	public void sendMessage(String message) {
		log.info("Send message {}", message);
		kafkaTemplate.send("str-topic", message);
	}
		

}
