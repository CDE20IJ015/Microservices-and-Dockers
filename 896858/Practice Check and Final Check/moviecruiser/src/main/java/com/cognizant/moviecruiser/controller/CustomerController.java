package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private MovieService service;

	@GetMapping("/movies")
	public List<Movie> getMoviesList() {
		return service.getMovieListCustomer();
	}

	@GetMapping("/movies/{movieId}")
	public Movie getMovie(@PathVariable long movieId) {
		return service.getMovie(movieId);
	}

}
