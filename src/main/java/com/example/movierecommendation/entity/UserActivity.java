package com.example.movierecommendation.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class UserActivity {

    @Id
    private String id;

    private String userId;
    private String activity;
}
