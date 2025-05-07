package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.dto.request.user.UserFindRequestDto;
import com.example.f02_online_shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Object register(@RequestBody UserFindRequestDto request) {
        return userService.registerUser(request);
    }

}
