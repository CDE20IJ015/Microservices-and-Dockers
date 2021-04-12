package com.cognizant.moviecruiser;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;

@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
public class MoviecruiserApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);

	private static MovieService movieService;

	public static void main(String[] args) {
		LOGGER.info("Inside Main");
		ApplicationContext context = SpringApplication.run(MoviecruiserApplication.class, args);
		
		movieService = context.getBean(MovieService.class);
		
		List<Movie> list = getAllMoviesToStore();
		movieService.save(list);
		LOGGER.info("Finished Storing...");
		testGetMovieListCustomer();
	}

	private static List<Movie> getAllMoviesToStore() {
		Movie movie;

		movie = new Movie(1, "Avatar", "$2,787,965,087", true, DateUtil.convertToDate("15/03/2017"), "Science Fiction",
				true);
		List<Movie> movieList = new ArrayList<>();
		movieList.add(movie);
		movie = new Movie(2, "The Avengers", "$1,518,812,988", true, DateUtil.convertToDate("23/12/2017"), "Superhero",
				false);
		movieList.add(movie);
		movie = new Movie(3, "Titanic", "$2,187,463,944", true, DateUtil.convertToDate("21/08/2017"), "Romance", false);
		movieList.add(movie);
		movie = new Movie(4, "Jurassic World", "$1,671,713,208", false, DateUtil.convertToDate("02/07/2017"),
				"Science Fiction", true);
		movieList.add(movie);
		movie = new Movie(5, "Avengers: End Game", "$2,750,760,348", true, DateUtil.convertToDate("02/11/2022"),
				"Superhero", true);
		movieList.add(movie);

		return movieList;
	}

	public static void testGetMovieListCustomer() {
		LOGGER.info("START");
		List<Movie> activeMovies = movieService.getMovieListCustomer();
		LOGGER.debug("Movies: {}", activeMovies);
		LOGGER.info("END");

	}

}

