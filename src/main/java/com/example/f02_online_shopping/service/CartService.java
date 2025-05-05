package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.model.User;

import java.util.List;

public interface CartService {
    List<Object> viewCart(User user);
}
