package com.example.f02_online_shopping.dto.response.cart;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CartResponseDto {
    private Integer cartId;
    private Integer userId;
    private List<CartItemDto> cartItems;
    public BigDecimal totalAmount;
}
