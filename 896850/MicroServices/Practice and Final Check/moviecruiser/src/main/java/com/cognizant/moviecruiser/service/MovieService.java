package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieDao moviedao;
	
	public List<Movie> getAllMovieAdmin(){
		
		return moviedao.getMovieListAdmin();
	}

	public void save(Movie movie) {
		moviedao.modifyMovie(movie);
	}

	public Movie getMovie(long id) {
		return moviedao.getMovie(id);
	}
}