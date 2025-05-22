package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.user.UserResponseDto;

import java.util.List;

public interface UserService {
    void checkUserValidity(Integer id);
    //Register
    UserResponseDto registerUser(UserRegisterRequestDto request);
    //Login
    UserResponseDto login(UserLoginRequestDto request);
    //Get user by id
    UserResponseDto getUserById(Integer id);
    //View user list
    List<UserResponseDto> getAllUsers();
    //Search user by email
    UserResponseDto getUserByEmail(String email);
    //Block user
    UserResponseDto blockUser(Integer id);
    //Update user
    UserResponseDto updateUser(UserUpdateRequestDto request);
}
