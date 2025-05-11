package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.model.UserModel;
import com.example.f02_online_shopping.service.CartService;
import com.example.f02_online_shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    UserService userService;

    @Override
    public List<Object> viewCart(UserModel user) {
        userService.checkUserValidity(user);
        return List.of();
    }
}
