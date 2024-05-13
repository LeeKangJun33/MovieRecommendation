package com.example.movierecommendation.service;

import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // 영화 정보를 저장하거나 업데이트.
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // 영화 ID에 해당하는 영화를 검색.
    public Optional<Movie> findMovieById(Long id) {
        return movieRepository.findById(id);
    }

    // 모든 영화 목록을 보여주기.
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    // 영화 ID에 해당하는 영화를 삭제.
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }


}
