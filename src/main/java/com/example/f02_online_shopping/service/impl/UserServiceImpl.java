package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.UserCreationRequestDto;
import com.example.f02_online_shopping.dto.response.UserCreationResponseDto;
import com.example.f02_online_shopping.model.User;
import com.example.f02_online_shopping.service.UserService;
import com.example.f02_online_shopping.service.UserValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserValidatorService userValidatorService;
    @Override
    public void checkUserValidity(User user) {
        //TODO: CEHCK USER VALID
    }

    @Override
    public UserCreationResponseDto createUser(UserCreationRequestDto userCreationRequestDto) {
        Object error = userValidatorService.validateCreateUserRequest(userCreationRequestDto);
        if (error != null) {
            UserCreationResponseDto responseDto = new UserCreationResponseDto();
            responseDto.setError(error);
            return responseDto;
        }
        return null;
    }
}
