package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.product.ProductCreateRequestDto;
import com.example.f02_online_shopping.dto.request.product.ProductUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.product.ProductResponseDto;
import com.example.f02_online_shopping.entity.Product;
import com.example.f02_online_shopping.exception.ApiException;
import com.example.f02_online_shopping.repository.ProductRepository;
import com.example.f02_online_shopping.service.ProductService;
import com.example.f02_online_shopping.service.ProductValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductValidatorService productValidatorService;

    @Override
    public List<ProductResponseDto> getInStockProductList() {
        List<Product> products = productRepository.findByStockGreaterThan(0);
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDto.setName(product.getName());
            productResponseDto.setDescription(product.getDescription());
            productResponseDto.setPrice(product.getPrice());
            productResponseDto.setCategory(product.getCategory());
            productResponseDtos.add(productResponseDto);
        }
        return productResponseDtos;
    }

    @Override
    public ProductResponseDto createProduct(ProductCreateRequestDto requestDto) {
        //Validate request
        Object error = productValidatorService.validateProduct(requestDto);
        if (error != null) {
            throw new ApiException(401, "Product detail not valid");
        }
        //Validate product exist first
        Optional<Product> productExist = Optional.ofNullable(productRepository.findProductByAttributes(
                requestDto.getName(), requestDto.getPrice(), requestDto.getOriginalPrice(),requestDto.getCategory()));
        if(productExist.isPresent()){
            throw new ApiException(404, "Product already exists");
        }
        //Create product
        Product productCreate = new Product();
        productCreate.setName(requestDto.getName());
        productCreate.setDescription(requestDto.getDescription());
        productCreate.setPrice(requestDto.getPrice());
        productCreate.setCategory(requestDto.getCategory());
        productCreate.setStock(requestDto.getStock());
        productCreate.setOriginal_price(requestDto.getOriginalPrice());
        productRepository.save(productCreate);
        //Return response
        return new ProductResponseDto(
                requestDto.getName(),
                requestDto.getDescription(),
                requestDto.getPrice(),
                requestDto.getOriginalPrice(),
                requestDto.getStock(),
                requestDto.getCategory());
    }

    @Override
    public ProductResponseDto updateProduct(ProductUpdateRequestDto requestDto) {
        int rowsAffect = productRepository.updateProductInfo(
                requestDto.getName(),
                requestDto.getDescription(),
                requestDto.getPrice(),
                requestDto.getStock(),
                requestDto.getOriginalPrice(),
                requestDto.getCategory(),
                requestDto.getProductId()
        );
        if(rowsAffect <= 0){
            throw new ApiException(404, "Product not found");
        }
        return new ProductResponseDto(
                requestDto.getName(),
                requestDto.getDescription(),
                requestDto.getPrice(),
                requestDto.getOriginalPrice(),
                requestDto.getStock(),
                requestDto.getCategory()
        );
    }

    @Override
    public Object deleteProduct(Integer id) {
        Product product = Optional.ofNullable(productRepository.findByProductId(id))
                .orElseThrow(() -> new ApiException(404, "Product not found"));
        productRepository.delete(product);
        return String.format("Delete product with product id %d successfully", id);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDto.setId(product.getId());
            productResponseDto.setName(product.getName());
            productResponseDto.setDescription(product.getDescription());
            productResponseDto.setPrice(product.getPrice());
            productResponseDto.setOriginalPrice(product.getOriginal_price());
            productResponseDto.setStock(product.getStock());
            productResponseDto.setCategory(product.getCategory());
            productResponseDtos.add(productResponseDto);
        }
        return productResponseDtos;
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
