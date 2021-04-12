package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.FavoriteService;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

	@Autowired
	private FavoriteService service;
	
	@PostMapping("/{userId}/{movieId}")
	public void addFavorites(@PathVariable String userId,@PathVariable long movieId) {
		service.addFavourites(userId, movieId);
	}
	
	@GetMapping("/{userId}")
	public List<Movie> getAllFavoriteMovie(@PathVariable String userId) throws FavoritesEmptyException{
		return service.getAllFavoritesMovies(userId);
	}
	
	@DeleteMapping("/{userId}/{movieId}")
	public void deleteFavorites(@PathVariable String userId,@PathVariable long movieId) {
		service.deleteFavorite(userId,movieId);
	}
}