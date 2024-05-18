package com.example.movierecommendation.repository;

import com.example.movierecommendation.entity.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @DisplayName("장르테스트")
    public void testFindByGenresContaining() {
        // Given
        Movie movie1 = new Movie();
        movie1.setTitle("대부");
        movie1.setDirector("프란시스 포드 코폴라");
        movie1.setGenres(List.of("느와르", "스릴러"));
        movie1.setReleaseYear(1972);
        movieRepository.save(movie1);

        Movie movie2 = new Movie();
        movie2.setTitle("범죄도시4");
        movie2.setDirector("허명행");
        movie2.setGenres(List.of("느와르", "액션"));
        movie2.setReleaseYear(2024);
        movieRepository.save(movie2);

        // When
        List<Movie> sciFiMovies = movieRepository.findByGenresContaining("느와르");

        // Then
        assertThat(sciFiMovies).hasSize(2);
        assertThat(sciFiMovies).extracting(Movie::getTitle).containsExactlyInAnyOrder("대부", "범죄도시4");
    }
}
