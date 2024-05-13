package com.example.movierecommendation.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;


@Data
@Entity
@Table(name = "movies")
@Document(indexName = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @Field(type = FieldType.Text)
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "release_year")
    private Integer releaseYear;

    @ElementCollection(fetch = FetchType.LAZY) // JPA용 설정
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    @Field(type = FieldType.Keyword) // Elasticsearch용 설정
    private List<String> genres;

}
