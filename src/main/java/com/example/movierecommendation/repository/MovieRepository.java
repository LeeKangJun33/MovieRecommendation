package com.example.movierecommendation.repository;

import com.example.movierecommendation.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie,Long> {
    List<Movie> findByGenresContaining(String genre);
    List<Movie> findTop10ByOrderByPopularityDesc();
}


