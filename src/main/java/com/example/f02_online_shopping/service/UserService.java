package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.response.user.UserResponseDto;

import java.util.List;

public interface UserService {
    void checkUserValidity(Integer id);

    //View user list
    List<UserResponseDto> getAllUsers();
    //Search user by email
    UserResponseDto getUserByEmail(String email);
    //Block user
    UserResponseDto blockUser(Integer id);
}
