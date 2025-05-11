package com.example.f02_online_shopping.dto.response.cart;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartItemDto {
    private Integer productId;
    private String productName;
    private Integer price;
    private Integer quantity;
    private BigDecimal total;
}
