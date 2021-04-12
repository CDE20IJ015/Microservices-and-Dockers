package com.cognizant.springlearn;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Country {
	
	@NotNull

	@Size(min=2, max=4, message="Country code should be 2 characters")
	private String id;
	
	private String name;
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	private Country() {
		super();
		LOGGER.info("Inside Country Constructor.");
		
	}
	public String getId() {
		LOGGER.info("Inside Get ID");
		return id;
	}
	public void setId(String id) {
		LOGGER.info("Inside Set ID");
		this.id = id;
	}
	public String getName() {
		LOGGER.info("Inside Get Name");
		return name;
		
	}
	public void setName(String name) {
		LOGGER.info("Inside Set Name");
		this.name = name;
		
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	}
}
