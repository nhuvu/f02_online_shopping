package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.product.ProductCreateRequestDto;
import com.example.f02_online_shopping.dto.request.product.ProductUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.product.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    //View in_stock products (products on sale)
    List<ProductResponseDto> getInStockProductList();

    //Add new product
    ProductResponseDto createProduct(ProductCreateRequestDto requestDto);

    //Update product
    ProductResponseDto updateProduct(ProductUpdateRequestDto requestDto);

    //Delete product
    void deleteProduct(Integer id);

    //View product list (all product)
    List<ProductResponseDto> getAllProducts();

    //Search product by name
    List<ProductResponseDto> getProductByName(String name);

    //Search product by category
    List<ProductResponseDto> getProductByCat(String category);

}
