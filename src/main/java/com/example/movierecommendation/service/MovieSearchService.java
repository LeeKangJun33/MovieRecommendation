package com.example.movierecommendation.service;

import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.repository.MovieSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSearchService {

    @Autowired
    private MovieSearchRepository movieSearchRepository;

    public List<Movie> searchMoviesByTitle(String title){
        return movieSearchRepository.findByTitleContaining(title);
    }
}
