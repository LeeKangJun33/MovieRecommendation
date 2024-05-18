package com.example.movierecommendation.service;

import com.example.movierecommendation.dto.Dashboard;
import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.repository.UserPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {


    private final UserPreferencesRepository userPreferencesRepository;

    @Autowired
    public DashboardService(UserPreferencesRepository userPreferencesRepository) {
        this.userPreferencesRepository = userPreferencesRepository;
    }

    public Dashboard getDashboardForUser(Long userId) {
        List<String> genres = userPreferencesRepository.findPreferredGenresByUserId(userId);
        List<Movie> recommendedMovies = new ArrayList<>();


        return new Dashboard(recommendedMovies, genres);
    }
}
