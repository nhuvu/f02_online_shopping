package com.example.f02_online_shopping.service;


import com.example.f02_online_shopping.dto.request.cart.CartAddProductRequestDto;
import com.example.f02_online_shopping.dto.response.cart.CartResponseDto;


public interface CartService {
    //Add product to cart
    Object addProductToCart(CartAddProductRequestDto requestDto);

    //View cart detail (product list)
    CartResponseDto viewCart(Integer userId);

    //Delete product in cart
    Object removeProductFromCart(Integer userId, Integer productId);

}
