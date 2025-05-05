package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.UserCreationRequestDto;
import com.example.f02_online_shopping.dto.response.UserCreationResponseDto;
import com.example.f02_online_shopping.model.User;

public interface UserService {
    void checkUserValidity(User user);
    UserCreationResponseDto createUser(UserCreationRequestDto userCreationRequestDto);
}
