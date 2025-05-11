package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.UserCreationRequestDto;
import com.example.f02_online_shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(UrlConstant.API_V1_CREATE_USER)
    public Object createUser(@RequestBody UserCreationRequestDto request) {
        return userService.createUser(request);
    }

    @GetMapping(UrlConstant.API_V1_GET_USER_BY_ID)
    public Object getDetailUser(@PathVariable(value = "id") Integer id) {
        return userService.getUserByid(id);
    }
}
