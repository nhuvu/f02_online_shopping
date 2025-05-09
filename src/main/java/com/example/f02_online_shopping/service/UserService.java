package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.dto.response.user.UserDto;
import com.example.f02_online_shopping.model.User;

public interface UserService {
    void checkUserValidity(Integer id);
    //1. Register new user
    UserDto registerUser(UserRegisterRequestDto request);
    //2. Old user login (email, password)
    UserDto login(UserLoginRequestDto request);


}
