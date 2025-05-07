package com.example.f02_online_shopping.dto.response.order;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItemDto {
    private Integer productId;
    private String productName;
    private BigDecimal price;
    private BigDecimal originalPrice;
    private Integer quantity;
}
