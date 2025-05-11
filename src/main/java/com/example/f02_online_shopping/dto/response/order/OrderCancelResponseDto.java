package com.example.f02_online_shopping.dto.response.order;

import com.example.f02_online_shopping.dto.general.GenericResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCancelResponseDto {
    private Integer orderIdDeleted;
    private GenericResponseDto response;
}
