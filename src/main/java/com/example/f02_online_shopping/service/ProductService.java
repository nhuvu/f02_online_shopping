package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.response.product.ProductDto;

import java.util.List;

public interface ProductService {
    //3. View list of available products
    List<ProductDto> getAllProducts();

    
}
