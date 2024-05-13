package com.example.movierecommendation.service;

import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CachedMovieService {

    @Autowired
    private MovieRepository movieRepository;

    // getMovieById 캐시 결과 방법
    @Cacheable(cacheNames = "movieCache", key = "#id")
    public Optional<Movie> getMovieById(Long id) {

        try {
            Thread.sleep(2000);  // 2초뒤
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return movieRepository.findById(id);
    }
}
