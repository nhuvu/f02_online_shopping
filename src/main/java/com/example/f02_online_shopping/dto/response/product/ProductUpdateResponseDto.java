package com.example.f02_online_shopping.dto.response.product;

import com.example.f02_online_shopping.dto.general.GenericResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateResponseDto {
    private ProductDto updateProduct;
    private GenericResponseDto response;
}
