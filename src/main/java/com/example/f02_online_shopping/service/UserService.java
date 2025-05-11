package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.UserCreationRequestDto;
import com.example.f02_online_shopping.dto.response.UserCreationResponseDto;
import com.example.f02_online_shopping.dto.response.UserDetailResponseDto;
import com.example.f02_online_shopping.model.UserModel;


public interface UserService {
    void checkUserValidity(UserModel user);
    UserCreationResponseDto createUser(UserCreationRequestDto userCreationRequestDto);
    UserDetailResponseDto getUserByid(Integer id);
}
