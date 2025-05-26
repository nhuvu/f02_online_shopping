package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.product.ProductCreateRequestDto;

public interface ProductValidatorService {
    Object validateProduct(ProductCreateRequestDto requestDto);
}
