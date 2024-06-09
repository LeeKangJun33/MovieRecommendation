package com.example.movierecommendation.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;


@Data
@Entity
@Table(name = "movies")
@Document(collation = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")

    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "release_year")
    private Integer releaseYear;

    @ElementCollection(fetch = FetchType.LAZY) // JPA용 설정
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private List<String> genres;

}
