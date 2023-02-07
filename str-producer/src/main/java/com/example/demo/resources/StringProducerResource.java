package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.StringProducerService;


@RestController
@RequestMapping(value = "/producer")
public class StringProducerResource {
	
	@Autowired
	public StringProducerService producerService;

	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody String message) {
		producerService.sendMessage(message);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
