package com.cosmos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AnswersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnswersServiceApplication.class, args);
	}

}
