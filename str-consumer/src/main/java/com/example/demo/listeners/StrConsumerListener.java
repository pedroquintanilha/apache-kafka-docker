package com.example.demo.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.custom.StrConsumerCustomListener;

import lombok.SneakyThrows;



@Component
public class StrConsumerListener {

	private static final Logger log = LogManager.getLogger(StrConsumerListener.class);
	
	@SneakyThrows
	// = throws Exception
	@StrConsumerCustomListener(groupId = "group-1") 
	public void create(String message) {
		log.info("CREATE ::: Receive message {}", message);
		throw new IllegalArgumentException("EXCEPTION...");
	}
	
	@StrConsumerCustomListener(groupId = "group-1")
	public void log(String message) {
		log.info("LOG ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
	public void history(String message) {
		log.info("HISTORY ::: Receive message {}", message);
	}
	
}
