package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;

public interface UserValidatorService {
    Object validateCreateUserRequest(UserRegisterRequestDto dto);
}
