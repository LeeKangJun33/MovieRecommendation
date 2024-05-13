package com.example.movierecommendation.service;

import com.example.movierecommendation.dto.Dashboard;
import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.entity.User;
import com.example.movierecommendation.repository.MovieSearchRepository;
import com.example.movierecommendation.repository.UserPreferencesRepository;
import com.example.movierecommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private MovieSearchRepository movieSearchRepository;

    @Autowired
    private UserPreferencesRepository userPreferencesRepository;

    public Dashboard getDashboardForUser(Long userId) {
        List<String> genres = userPreferencesRepository.findPreferredGenresByUserId(userId);
        List<Movie> recommendedMovies = new ArrayList<>();

        for (String genre : genres) {
            recommendedMovies.addAll(movieSearchRepository.findByTitleContaining(genre));
        }

        return new Dashboard(recommendedMovies, genres);
    }
}
