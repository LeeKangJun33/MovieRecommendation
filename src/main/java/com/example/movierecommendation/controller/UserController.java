package com.example.movierecommendation.controller;

import com.example.movierecommendation.dto.UserInfo;
import com.example.movierecommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    private  UserService userService;

    @GetMapping("/users/{userId}")
    public UserInfo getUserInfo(@PathVariable Long userId) {
        return userService.getUserInfo(userId);
    }
}
