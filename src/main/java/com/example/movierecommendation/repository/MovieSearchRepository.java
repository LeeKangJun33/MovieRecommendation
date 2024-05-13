package com.example.movierecommendation.repository;

import com.example.movierecommendation.entity.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSearchRepository extends ElasticsearchRepository<Movie,String > {

    //영화 제목을 포함하는 영화를 검색
    List<Movie> findByTitleContaining(String title);

    // 특정 장르를 포함하는 영화를 검색합니다.
    List<Movie> findByGenresContains(String genre);

}
