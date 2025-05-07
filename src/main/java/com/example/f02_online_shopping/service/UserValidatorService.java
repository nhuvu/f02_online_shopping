package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.user.UserFindRequestDto;

public interface UserValidatorService {
    Object validateCreateUserRequest(UserFindRequestDto dto);
}
