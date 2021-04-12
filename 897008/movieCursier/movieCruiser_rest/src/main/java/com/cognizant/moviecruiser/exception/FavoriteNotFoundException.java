package com.cognizant.moviecruiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Movie(s) in Favourite List")
public class FavoriteNotFoundException extends Exception{

	public FavoriteNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
