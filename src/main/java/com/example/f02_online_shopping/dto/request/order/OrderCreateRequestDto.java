package com.example.f02_online_shopping.dto.request.order;

import com.example.f02_online_shopping.dto.response.order.OrderItemDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderCreateRequestDto {
    private Integer userId;
    private String description;
    private String status;
    private BigDecimal totalAmount;
    private List<OrderItemDto> items;
}
