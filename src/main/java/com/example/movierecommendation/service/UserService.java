package com.example.movierecommendation.service;

import com.example.movierecommendation.dto.UserInfo;
import com.example.movierecommendation.entity.User;
import com.example.movierecommendation.entity.UserActivity;
import com.example.movierecommendation.repository.UserActivityRepository;
import com.example.movierecommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserActivityRepository userActivityRepository;

    public UserInfo getUserInfo(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("사용자를 찾을수없습니다."));
        List<UserActivity> activities = userActivityRepository.findByUserId(String.valueOf(userId));

        return new UserInfo(user, activities);
    }
}
