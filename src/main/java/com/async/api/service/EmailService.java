package com.async.api.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	
	@Async("asyncExecutor")
	public String sendEmail() {
		
		System.out.println("Start Mail Sending " + new Date());
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("End Mail Sending " + new Date());
		
		return "Success";
	}
	
}
