package com.example.movierecommendation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.repository.NoRepositoryBean;

@Configuration
@EnableElasticsearchRepositories(
        basePackages = "com.example.movierecommendation.repository",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {com.example.movierecommendation.repository.MovieSearchRepository.class}
        ),
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = NoRepositoryBean.class
        )
)
public class ElasticsearchConfig {
    // Elasticsearch 구성 설정
}
