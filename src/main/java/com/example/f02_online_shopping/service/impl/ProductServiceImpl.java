package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.product.ProductCreateRequestDto;
import com.example.f02_online_shopping.dto.request.product.ProductUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.product.ProductResponseDto;
import com.example.f02_online_shopping.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductResponseDto> getInStockProductList() {
        return List.of();
    }

    @Override
    public ProductResponseDto createProduct(ProductCreateRequestDto requestDto) {
        return null;
    }

    @Override
    public ProductResponseDto updateProduct(ProductUpdateRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {

    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return List.of();
    }

    @Override
    public List<ProductResponseDto> getProductByName(String name) {
        return List.of();
    }

    @Override
    public List<ProductResponseDto> getProductByCat(String category) {
        return List.of();
    }
}
