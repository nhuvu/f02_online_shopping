package com.example.f02_online_shopping.dto.request.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductUpdateRequestDto {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private BigDecimal originalPrice;
    private String category;
}
