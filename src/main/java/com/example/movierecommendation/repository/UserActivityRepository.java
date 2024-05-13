package com.example.movierecommendation.repository;

import com.example.movierecommendation.entity.UserActivity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityRepository extends MongoRepository<UserActivity,String> {
    List<UserActivity> findByUserId(String userId);
}
