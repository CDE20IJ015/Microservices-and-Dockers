package com.cognizant.truyum;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan
public class TruyumApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TruyumApplication.class, args);
		
		displayMenuItems();
	}

	public static void displayMenuItems() {

		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		LOGGER.info("START");
		ArrayList<MenuItem> menuItem = (ArrayList<MenuItem>) context.getBean("menuItemList");
		// Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("MenuItem : {}", menuItem.toString());
		LOGGER.info("END");
	}
}
