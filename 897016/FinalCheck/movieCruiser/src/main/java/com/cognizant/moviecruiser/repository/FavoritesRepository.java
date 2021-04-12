package com.cognizant.moviecruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Favorites;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {
	@Query("select f from Favorites f left join fetch f.user u where u.id= :id")
	public List<Favorites> findById(@Param("id") int id);
}
