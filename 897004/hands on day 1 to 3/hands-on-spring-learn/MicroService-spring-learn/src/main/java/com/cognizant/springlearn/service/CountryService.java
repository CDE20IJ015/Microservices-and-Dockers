package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

public class CountryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	
	public Country getIndia() {
		
		Country country = (Country) context.getBean("in", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		return country;
	}
	
	
	public List<Country> getAllCountries(){
		
		List<Country> ctr = new ArrayList<>();
		ctr = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
		LOGGER.debug("Country : {}", ctr.toString());
		return ctr;
	}
	
	public Country getCountry(String id) throws CountryNotFoundException {
		
		List<Country> ctr = new ArrayList<>();
		ctr = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
		
		return ctr.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}


	public Country addCountry(Country country) {
		// TODO Auto-generated method stub
		country.setId("AUSTRA");
		country.setName("Australia");
		List<Country> ctr = new ArrayList<>();
		ctr = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
		ctr.add(country);
		
		
		return country;
	}
	
	public void updateCountry(String id) {
		
		List<Country> ctr = new ArrayList<>();
		ctr = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
		for(Country c : ctr) {
			if(c.getId().equals(id)) {
				String newName="New Zealand";
				c.setName(newName);
			}
		}
		
	}


	public void delete(String id) {
		// TODO Auto-generated method stub
		List<Country> ctr = new ArrayList<>();
		ctr = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
		for(Country c : ctr) {
			if(c.getId().equals(id)) {
				
				System.out.println(ctr.remove(c));
			}
		}
		
		
		
	}
	
	
	
}
