package com.example.movierecommendation.controller;

import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getRecommendationsByGenre(@PathVariable String genre) {
        List<Movie> movies = recommendationService.recommendMoviesByGenre(genre);
        if (!movies.isEmpty()) {
            return ResponseEntity.ok(movies);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/popular")
    public ResponseEntity<List<Movie>> getPopularRecommendations() {
        List<Movie> movies = recommendationService.recommendPopularMovies();
        if (!movies.isEmpty()) {
            return ResponseEntity.ok(movies);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
