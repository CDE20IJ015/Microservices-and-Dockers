package com.cognizant.moviecruiser.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;

@Service
public interface MovieDao {
	public List<Movie> getMovieListAdmin();

	public List<Movie> getMovieListCustomer();

	public void modifyMovie(Movie movie);

	public Movie getMovie(long movieId);
	
	public void save(List<Movie> movies);
	
}
