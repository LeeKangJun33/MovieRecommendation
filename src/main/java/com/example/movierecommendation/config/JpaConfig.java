package com.example.movierecommendation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.movierecommendation.repository",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {com.example.movierecommendation.repository.MovieRepository.class}
        ),
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = NoRepositoryBean.class
        )
)
public class JpaConfig {
    // JPA 구성 설정
}
