package com.cognizant.truyum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Item(s) Found in Cart")
public class CartEmptyException extends Exception {

	public CartEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
