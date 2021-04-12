package com.cognizant.springlearn.controller;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CountryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	CountryService cs = new CountryService();
	
	@GetMapping("/hello")
	public String GetHello() {
		
		return "Hello World!!!";
	}
	
	@RequestMapping("/country")
	public Country getIndia() {
		
		return cs.getIndia();
		
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		
		return cs.getAllCountries();
	}
	
	@RequestMapping("/countries/{id}")
	public Country getCountry(@PathVariable String id) throws CountryNotFoundException {
		return cs.getCountry(id);
	}
	
	@PostMapping("/Add")
	public Country addCountry( Country country) {
		LOGGER.info("START");
		
		/*
		 * // Create validator factory
		 * 
		 * ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		 * Validator validator = factory.getValidator(); // Validation is done against
		 * the annotations defined in country bean Set<ConstraintViolation<Country>>
		 * violations = validator.validate(country); List<String> errors = new
		 * ArrayList<String>(); // Accumulate all errors in an ArrayList of type String
		 * for (ConstraintViolation<Country> violation : violations) {
		 * errors.add(violation.getMessage()); }
		 * 
		 * // Throw exception so that the user of this web service receives appropriate
		 * // error message
		 * 
		 * if (violations.size() > 0) { throw new
		 * ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString()); }
		 */
		
		return cs.addCountry(country);
	}
	
	
	@PutMapping("/update/{id}")
	public void updateCountry(@PathVariable String id) {
		
		cs.updateCountry(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCountry(String id) {
		cs.delete(id);
	}


}
