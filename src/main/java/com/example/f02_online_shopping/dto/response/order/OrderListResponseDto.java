package com.example.f02_online_shopping.dto.response.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderListResponseDto {
    private List<OrderResponseDto> orders;
}
