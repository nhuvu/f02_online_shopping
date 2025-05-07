package com.example.f02_online_shopping.dto.response.cart;

import java.math.BigDecimal;
import java.util.List;

public class CartDto {
    private Integer cartId;
    private Integer userId;
    private List<CartItemDto> cartItems;
    public BigDecimal totalAmount;
}
