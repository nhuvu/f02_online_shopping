package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.dto.response.user.UserResponseDto;

public interface AuthService {
    //Register
    UserResponseDto createUser(UserRegisterRequestDto request);

    //Login
    UserResponseDto login(UserLoginRequestDto requestDto);
}
