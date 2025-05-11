package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.model.UserModel;

import java.util.List;

public interface CartService {
    List<Object> viewCart(UserModel user);
}
