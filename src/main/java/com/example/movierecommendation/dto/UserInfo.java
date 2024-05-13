package com.example.movierecommendation.dto;

import com.example.movierecommendation.entity.User;
import com.example.movierecommendation.entity.UserActivity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfo {
    private User user;
    private List<UserActivity> activities;
}
