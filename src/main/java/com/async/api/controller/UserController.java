package com.async.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.async.api.output.UserInfo;
import com.async.api.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(value = "", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<List<UserInfo>>> getUSerInfo() {
		System.out.println("Inside User Controller : User API : " + new Date());

		return new ResponseEntity<>( userService.getUserInfo(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/mono", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Mono<UserInfo>> getUSerInfoMono() {
		System.out.println("Inside User Controller : User API : " + new Date());

		return new ResponseEntity<>( userService.getUserInfoMono(),HttpStatus.OK);
	}

}
