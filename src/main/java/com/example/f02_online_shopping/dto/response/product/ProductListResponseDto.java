package com.example.f02_online_shopping.dto.response.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductListResponseDto {
    private List<ProductResponseDto> products;
}
