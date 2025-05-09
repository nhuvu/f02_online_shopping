package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.cart.CartDetailRequestDto;
import com.example.f02_online_shopping.dto.response.cart.CartDto;
import com.example.f02_online_shopping.model.User;

import java.util.List;

public interface CartService {
    //1. User view cart
    CartDto viewCart(Integer userId);
    //2.
}
