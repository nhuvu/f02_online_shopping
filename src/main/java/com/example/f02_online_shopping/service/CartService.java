package com.example.f02_online_shopping.service;


import com.example.f02_online_shopping.dto.request.cart.CartAddProductRequestDto;
import com.example.f02_online_shopping.dto.request.cart.CartDeleteProductRequestDto;
import com.example.f02_online_shopping.dto.response.cart.CartItemDto;
import com.example.f02_online_shopping.dto.response.cart.CartResponseDto;

import java.util.List;

public interface CartService {
    //Add product to cart
    CartResponseDto addProductToCart(CartAddProductRequestDto requestDto);

    //View cart detail (product list)
    CartResponseDto viewCart(Integer userId);

    //Delete product in cart
    Object removeProductFromCart(CartDeleteProductRequestDto requestDto);
}
