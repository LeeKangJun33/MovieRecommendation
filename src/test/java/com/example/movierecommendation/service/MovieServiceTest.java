package com.example.movierecommendation.service;


import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("장르테스트-서비스")
    public void testGetMoviesByGenre(){
        // Given
        Movie movie1 = new Movie();
        movie1.setId(1L);
        movie1.setTitle("대부");
        movie1.setDirector("프란시스 포드 코폴라");
        movie1.setGenres(List.of("느와르", "스릴러"));
        movie1.setReleaseYear(1972);
        movieRepository.save(movie1);

        Movie movie2 = new Movie();
        movie2.setId(2L);
        movie2.setTitle("범죄도시4");
        movie2.setDirector("허명행");
        movie2.setGenres(List.of("느와르", "액션"));
        movie2.setReleaseYear(2024);
        movieRepository.save(movie2);

        given(movieRepository.findByGenresContaining(anyString())).willReturn(List.of(movie1, movie2));


        // When
        List<Movie> sciFiMovies = movieRepository.findByGenresContaining("느와르");

        // Then
        assertThat(sciFiMovies).hasSize(2);
        assertThat(sciFiMovies).extracting(Movie::getTitle).containsExactlyInAnyOrder("대부", "범죄도시4");
    }
}
