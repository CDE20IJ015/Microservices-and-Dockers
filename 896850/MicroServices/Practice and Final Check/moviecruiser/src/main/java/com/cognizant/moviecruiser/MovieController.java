package com.cognizant.moviecruiser;

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
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("")
	public List<Movie> getAllMovieAdmin(){
		
		return movieService.getAllMovieAdmin();
	}
	
	@PutMapping("")
	public void modifyMovie(@RequestBody Movie movie) {
		
		movieService.save(movie);
	}
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable long id) {
		return movieService.getMovie(id);
	}
	
	
}