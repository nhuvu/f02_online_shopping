package com.example.f02_online_shopping.dto.response.cart;

import com.example.f02_online_shopping.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDto {
    private Integer cartId;
    private Integer userId;
    private List<String> items;
    public BigDecimal totalAmount;
}
