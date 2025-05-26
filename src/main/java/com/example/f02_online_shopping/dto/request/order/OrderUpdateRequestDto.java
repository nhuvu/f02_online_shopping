package com.example.f02_online_shopping.dto.request.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderUpdateRequestDto {
    private Integer userId;
    private Integer orderId;
    private String description;
}
