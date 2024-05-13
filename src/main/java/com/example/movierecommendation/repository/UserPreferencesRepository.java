package com.example.movierecommendation.repository;

import com.example.movierecommendation.entity.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPreferencesRepository extends JpaRepository<UserPreferences,Long> {
    @Query("SELECT p.genres FROM UserPreferences p WHERE p.user.id = :userId")
    List<String> findPreferredGenresByUserId(Long userId);

}
