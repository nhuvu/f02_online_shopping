package com.example.f02_online_shopping.dto.response.order;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private Integer id;
    private String status;
    private BigDecimal totalAmount;
    private String description;
    private Integer userId;
    private List<OrderItemDto> items;
}
