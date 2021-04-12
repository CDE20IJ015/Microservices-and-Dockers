package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication

@ComponentScan(basePackages="com.cognizant.springlearn")
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		//displayCountry();
		displayCountries();
	}
	public static void displayDate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat formatter = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			LOGGER.info("START");
			Date date = formatter.parse("31/12/2018"); 
			String strDate= formatter.format(date); 
			LOGGER.debug(strDate);
			LOGGER.info("END");
			//System.out.println(strDate);
		}
		catch(ParseException e) {
			e.printStackTrace();
		} 
		
		
	} 
	public static void displayCountry() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("in", Country.class);
		
		Country anotherCountry = context.getBean("de", Country.class);

		LOGGER.debug("Country : {}", country.toString());
		LOGGER.debug("Country : {}", anotherCountry.toString());
		
		
		
	}
	
	public static void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> ctr = new ArrayList<>();
		ctr = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
		LOGGER.debug("Country : {}", ctr.toString());
		
		
		
	}

}
