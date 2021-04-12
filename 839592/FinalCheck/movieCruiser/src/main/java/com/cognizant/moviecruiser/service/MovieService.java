package com.cognizant.moviecruiser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;

	@Transactional
	public List<Movie> getMovieListAdmin() {
		return movieRepository.findAll();
	}

	@Transactional
	public List<Movie> getMovieListCustomer() {
		return movieRepository.findAllCustomer();
	}

	@Transactional
	public Movie getMovie(int id) {
		return movieRepository.getOne(id);
	}

	@Transactional
	public void editMovie(Movie movie) {
		Movie movie2 = movieRepository.getOne(movie.getId());
		movie2.setTitle(movie.getTitle());
		movie2.setBoxOffice(movie.getBoxOffice());
		movie2.setActive(movie.getActive());
		movie2.setDateOfLaunch(movie.getDateOfLaunch());
		movie2.setGenre(movie.getGenre());
		movie2.setHasTeaser(movie.getHasTeaser());
		movieRepository.save(movie2);
	}

}
