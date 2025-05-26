package com.example.f02_online_shopping.service;


import com.example.f02_online_shopping.dto.request.cart.CartUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.cart.CartResponseDto;

import java.util.List;

public interface CartService {
    //Add product to cart
    CartResponseDto addProductToCart(CartUpdateRequestDto requestDto);

    //View cart detail (product list)
    List<Object> viewCart(Integer userId);

    //Delete product in cart
    void removeProductFromCart(Integer cartId, Integer productId);
}
