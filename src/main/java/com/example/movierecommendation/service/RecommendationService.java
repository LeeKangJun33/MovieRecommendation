package com.example.movierecommendation.service;

import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.entity.UserRating;
import com.example.movierecommendation.repository.MovieRepository;
import com.example.movierecommendation.repository.MovieSearchRepository;
import com.example.movierecommendation.repository.UserPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecommendationService {
    @Autowired
    private  MovieRepository movieRepository;

    @Autowired
    private MovieSearchRepository movieSearchRepository;

    public List<Movie> searchMoviesByTitle(String title) {
        return movieSearchRepository.findByTitleContaining(title);
    }

    public List<Movie> searchMoviesByGenre(String genre) {
        return movieSearchRepository.findByGenresContains(genre);
    }
}
