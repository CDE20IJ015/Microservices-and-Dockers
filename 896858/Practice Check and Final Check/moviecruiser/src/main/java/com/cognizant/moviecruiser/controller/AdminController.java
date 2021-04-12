package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MovieService service;

	@GetMapping("/movies")
	public List<Movie> getMoviesList() {
		return service.getMovieListAdmin();
	}
	
	@GetMapping("/movies/{movieId}")
	public Movie getMovie(@PathVariable long movieId) {
		return service.getMovie(movieId);
	}
	
	@PutMapping()
	public void modifyMovieDetails(@RequestBody Movie movie) {
		service.modifyMovie(movie);
	}
}
