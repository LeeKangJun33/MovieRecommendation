package com.example.movierecommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.movierecommendation.repository") //Spring Data JPA 리포지토리가 있는 패키지를 명시적으로 스캔
public class MovieRecommendationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRecommendationApplication.class, args);
    }

}
