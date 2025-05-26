package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.cart.CartUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.cart.CartResponseDto;
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
    public CartResponseDto addProductToCart(CartUpdateRequestDto requestDto) {
        return null;
    }

    @Override
    public List<Object> viewCart(Integer userId) {
        userService.checkUserValidity(userId);
        return List.of();
    }

    @Override
    public void removeProductFromCart(Integer cartId, Integer productId) {

    }
}
