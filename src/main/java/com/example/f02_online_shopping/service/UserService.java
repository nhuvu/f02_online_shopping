package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.user.UserResponseDto;

public interface UserService {
    void checkUserValidity(Integer id);
    //1. Register new user
    UserResponseDto registerUser(UserRegisterRequestDto request);
    //2. Old user login (email, password)
    UserResponseDto login(UserLoginRequestDto request);

    UserResponseDto getUserById(Integer id);

    UserResponseDto updateUser(UserUpdateRequestDto request);
}
