package com.cognizant.moviecruiser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.model.User;
import com.cognizant.moviecruiser.repository.FavoritesRepository;

@Service
public class FavoritesService {
	@Autowired
	FavoritesRepository favoritesRepository;
	@Autowired
	MovieService movieService;
	@Autowired
	UserService userService; 
	
	@Transactional
	public void addToFavorites(int movieId) {		
		User user = userService.getUser(1);
		Movie movie = movieService.getMovie(movieId);
		Favorites favorites = new Favorites();
		favorites.setUser(user);
		favorites.setMovie(movie);
		favoritesRepository.save(favorites);
	}

	@Transactional
	public List<Favorites> getFavorites(){
		return favoritesRepository.findById(1);
	}
	@Transactional
	public void deleteFav(int id) {
		favoritesRepository.delete(favoritesRepository.getOne(id));
	}
	
}
