package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.UserCreationRequestDto;

public interface UserValidatorService {
    Object validateCreateUserRequest(UserCreationRequestDto dto);
}
