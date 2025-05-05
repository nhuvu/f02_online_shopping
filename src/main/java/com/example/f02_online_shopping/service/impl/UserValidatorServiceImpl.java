package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.UserCreationRequestDto;
import com.example.f02_online_shopping.service.UserValidatorService;
import org.springframework.stereotype.Service;

@Service
public class UserValidatorServiceImpl implements UserValidatorService {

    @Override
    public Object validateCreateUserRequest(UserCreationRequestDto dto) {
        if(dto.getUsername() == null ){
            return "Username is required";
        }
        if(dto.getUsername().length() < 25 ){
            return "Username is too long";
        }
        if(dto.getPassword() == null ){
            return "Password is required";
        }
        if(dto.getPassword().length() < 6 ){
            return "Password is too short";
        }
        return null;
    }
}
