package com.example.f02_online_shopping.dto.response.order;

import java.math.BigDecimal;

public class OrderItemDto {
    private Integer productId;
    private String productName;
    private BigDecimal price;
    private BigDecimal originalPrice;
    private Integer quantity;
}
