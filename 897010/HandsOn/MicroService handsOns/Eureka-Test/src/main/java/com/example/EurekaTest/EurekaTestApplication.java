package com.example.EurekaTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaTestApplication.class, args);
	}

}
