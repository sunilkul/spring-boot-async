package com.async.api;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;


@Configuration

@EnableAsync
public class AsyncConfig {

	@Bean(name = "asyncExecutor")
	public Executor asyncExecutor() {
	   ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	   executor.setCorePoolSize(10);
	   executor.setMaxPoolSize(100);
	   executor.setQueueCapacity(100);
	   executor.setThreadNamePrefix("Async-");
	   executor.initialize();
	   return executor;
	}
	
}
