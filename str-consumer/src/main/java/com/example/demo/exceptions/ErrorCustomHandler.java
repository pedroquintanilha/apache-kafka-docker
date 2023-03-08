package com.example.demo.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.example.demo.listeners.StrConsumerListener;

@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
	
	private static final Logger log = LogManager.getLogger(StrConsumerListener.class);

	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		log.info("EXCEPTION HANDLER  :::  Capturei um erro");
		log.info("Payload ::: {}", message.getPayload());
		log.info("Headers ::: {}", message.getHeaders());
		log.info("Offset ::: {}", message.getHeaders().get("kafka_offset"));
		log.info("Message exception ::: {}", exception.getMessage());
		return null;
	}

}
