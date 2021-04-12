package com.cognizant.moviecruiser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoriteService {

	@Autowired
	private FavoritesDao dao;
	
	public void addFavourites(String userId, long movieId) {
		dao.addFavoritesMovie(userId, movieId);
	}
	
	public List<Movie> getAllFavoritesMovies(String userId) throws FavoritesEmptyException{
		return dao.getAllFavoritesMovies(userId);
	}

	public void deleteFavorite(String userId, long movieId) {
		dao.removeFavoritesMovie(userId, movieId);
		
	}
}