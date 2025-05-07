package com.example.f02_online_shopping.dto.request.cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDeleteProductRequestDto {
    private Integer userId;
    private Integer productId;
}
