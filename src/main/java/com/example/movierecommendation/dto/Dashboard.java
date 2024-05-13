package com.example.movierecommendation.dto;

import com.example.movierecommendation.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dashboard {

    private List<Movie> recommendedMovies;

    private List<String> favoriteGenres;
}
