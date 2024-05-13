package com.example.movierecommendation.controller;

import com.example.movierecommendation.dto.Dashboard;
import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.service.DashboardService;
import com.example.movierecommendation.service.MovieSearchService;
import com.example.movierecommendation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieSearchService movieSearchService;

    @Autowired
    private DashboardService dashboardService;

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return movieService.findMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){

        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMoviesByTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieSearchService.searchMoviesByTitle(title));
    }

    @GetMapping("/dashboard/{userId}")
    public ResponseEntity<Dashboard> getUserDashboard(@PathVariable Long userId) {
        return ResponseEntity.ok(dashboardService.getDashboardForUser(userId));
    }
}
