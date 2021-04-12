package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Movie;

public interface FavoritesDao {
	public void addFavoritesMovie(String userId, long movieId);

	public List<Movie> getAllFavoritesMovies(String userId) throws FavoritesEmptyException;

	public void removeFavoritesMovie(String userId, long movieId);
}