package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.dao.FavoritesDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Movie;

@RestController
@RequestMapping("customer/favorite")
public class FavoriteController {

	@Autowired
	private FavoritesDaoCollectionImpl dao;

	@PostMapping("/{userId}/{movieId}")
	public void addFavorite(@PathVariable long userId, @PathVariable long movieId) {
		dao.addFavoritesMovie(userId, movieId);
	}

	@GetMapping("/{userId}")
	public List<Movie> viewFavoriteMovies(@PathVariable long userId) throws FavoritesEmptyException {
		return dao.getAllFavoritesMovies(userId);
	}

	@DeleteMapping("/{userId}/{movieId}")
	public void deleteFavorite(@PathVariable long userId, @PathVariable long movieId) {
		dao.removeFavoritesMovie(userId, movieId);
	}

}
