package com.example.movierecommendation.service;

import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private  MovieRepository movieRepository;
    @Autowired
    public RecommendationService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> recommendMoviesByGenre(String genre) {
        return movieRepository.findByGenresContaining(genre);
    }

    public List<Movie> recommendPopularMovies() {
        return movieRepository.findTop10ByOrderByPopularityDesc();
    }

}
