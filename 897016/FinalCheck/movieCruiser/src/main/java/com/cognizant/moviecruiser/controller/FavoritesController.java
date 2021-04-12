package com.cognizant.moviecruiser.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.FavoriteNotFoundException;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.FavoritesService;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private FavoritesService favoritesService;
	
	@Autowired
	private MovieService movieService;

	@PostMapping("/{movieId}")
	public void addToFavorites(@PathVariable int movieId, ModelMap map) {
		LOGGER.info("Start ");
		List<Movie> movieList = movieService.getMovieListCustomer();
		map.put("movieList", movieList);
		LOGGER.debug("List:{}", movieList);
		favoritesService.addToFavorites(movieId);
		LOGGER.info("End ");
		//return "movie-list-customer-notification";
	}

	@GetMapping()
	public List<Favorites> favorites(ModelMap model) throws Exception {
		LOGGER.info("Start");
		List<Favorites> favoritess = favoritesService.getFavorites();
		LOGGER.debug("Favorites:{}", favoritess);
		if (favoritess.size() == 0) {
			//return "favorites-empty";
		}	
		model.put("favorites", favoritess);
		model.put("total", favoritess.size());
		LOGGER.info("End");
		return favoritess;
		//return "favorites";
	}

	@DeleteMapping("/{favId}")
	public void deleteItem(@PathVariable int favId, ModelMap model) throws FavoriteNotFoundException {
		LOGGER.info("Start");
		favoritesService.deleteFav(favId);
		List<Favorites> favoritess = favoritesService.getFavorites();
		LOGGER.debug("Favorites:{}", favoritess);
		if (favoritess.size() == 0) {
			//return "favorites-empty";
			throw new FavoriteNotFoundException("No Movie(s) in Favourite List");
		}
			
		model.put("favorites", favoritess);
		model.put("total", favoritess.size());
		LOGGER.info("End");
		//return "favorites-notification";
	}

}
