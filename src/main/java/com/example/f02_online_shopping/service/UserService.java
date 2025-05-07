package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.user.UserFindRequestDto;
import com.example.f02_online_shopping.dto.response.user.UserDto;
import com.example.f02_online_shopping.model.User;

public interface UserService {
    void checkUserValidity(User user);
    UserDto registerUser(UserFindRequestDto userCreationRequestDto);
}
