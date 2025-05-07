package com.example.f02_online_shopping.dto.response.order;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private Integer id;
    private String status;
    private BigDecimal totalAmount;
    private String description;
    private Integer userId;
    private List<OrderItemDto> items;
}
