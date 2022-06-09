package com.async.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.async.api.service.EmailService;

@RestController
@RequestMapping(value = "email")
public class EmailController {

	@Autowired
	EmailService emailService;
	
	
	@Async("asyncExecutor")
	@GetMapping(value = "")
	public ResponseEntity<String> sendEmail(){
		
		
		return new ResponseEntity<>(emailService.sendEmail(), HttpStatus.OK);
	}
	
}
