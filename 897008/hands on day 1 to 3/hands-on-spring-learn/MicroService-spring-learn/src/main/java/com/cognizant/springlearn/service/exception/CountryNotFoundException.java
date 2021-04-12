package com.cognizant.springlearn.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends Exception  {
	public CountryNotFoundException(String msg) {
		super(msg);
	}
}
