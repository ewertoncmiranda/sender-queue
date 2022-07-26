package com.miranda.sqsfila;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
public class SenderQueueApplication {
	public static void main(String[] args) {
		SpringApplication.run(SenderQueueApplication.class, args);
	}

}
