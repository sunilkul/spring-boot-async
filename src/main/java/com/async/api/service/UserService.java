package com.async.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.async.api.output.UserInfo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	
	public Flux<List<UserInfo>> getUserInfo() {

		System.out.println("Start of delay: " + new Date());
		// Delay for 7 seconds
		try {
			Thread.sleep(7000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("End of delay: " + new Date());

		
		
		List<UserInfo> userInfoList = new ArrayList<>();

		for (int i = 0; i <= 10; i++) {

			UserInfo u = new UserInfo();
			u.setUserId(i);
			u.setUserName("USer Name " + i);
			u.setSalary(i * 100.00);
			userInfoList.add(u);
		}

		return Flux.just(userInfoList);
	}
	
	public Mono<UserInfo> getUserInfoMono() {

		System.out.println("Start of delay: " + new Date());
		// Delay for 7 seconds
		try {
			Thread.sleep(7000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("End of delay: " + new Date());

		
		


			UserInfo u = new UserInfo();
			u.setUserId(7043);
			u.setUserName("Sunil Kulkarni");
			u.setSalary(10000.00);


		return Mono.just(u);
	}
		
}
