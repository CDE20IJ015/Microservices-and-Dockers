package com.security.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.security")
public class JwtSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityDemoApplication.class, args);
	}

}
