package com.example.demo.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class StrConsumerListener {

	private static final Logger log = LogManager.getLogger(StrConsumerListener.class);
	
	@KafkaListener(groupId = "group-1", topics= "str-topic", containerFactory = "strContainerFactory")
	public void listener(String message) {
		log.info("Receive message {}", message);
	}
	
}
