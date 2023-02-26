package com.example.demo.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;



@Component
public class StrConsumerListener {

	private static final Logger log = LogManager.getLogger(StrConsumerListener.class);
	
	@KafkaListener(groupId = "group-1",
			topicPartitions = {
					@TopicPartition(topic = "str-topic", partitions = {"0"})
			}
			, containerFactory = "strContainerFactory")
	public void create(String message) {
		log.info("CREATE ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-1",
			topicPartitions = {
					@TopicPartition(topic = "str-topic", partitions = {"1"})
			}
			, containerFactory = "strContainerFactory")
	public void log(String message) {
		log.info("LOG ::: Receive message {}", message);
	}
}
