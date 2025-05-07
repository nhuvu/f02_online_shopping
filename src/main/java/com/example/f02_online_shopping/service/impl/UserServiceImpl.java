package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.user.UserFindRequestDto;
import com.example.f02_online_shopping.dto.response.user.UserDto;
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
        //TODO: CHECK USER VALIDITY
    }

    @Override
    public UserDto registerUser(UserFindRequestDto userCreationRequestDto) {
        Object error = userValidatorService.validateCreateUserRequest(userCreationRequestDto);
        if (error != null) {
            UserDto responseDto = new UserDto();
            responseDto.setError(error);
            return responseDto;
        }
        return null;
    }
}
