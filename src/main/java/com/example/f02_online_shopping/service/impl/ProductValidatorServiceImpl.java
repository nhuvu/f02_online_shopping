package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.product.ProductCreateRequestDto;
import com.example.f02_online_shopping.dto.request.product.ProductUpdateRequestDto;
import com.example.f02_online_shopping.service.ProductValidatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductValidatorServiceImpl implements ProductValidatorService {

    @Override
    public Object validateProduct(ProductCreateRequestDto requestDto) {
        Object validateName = validateName(requestDto.getName());
        Object validatePrice = validatePrice(requestDto.getPrice());
        Object validateOriginalPrice = validatePrice(requestDto.getOriginalPrice());
        Object validateStock = validateStock(requestDto.getStock());
        if(validateName == null && validatePrice == null && validateOriginalPrice == null && validateStock == null){
            return null;
        }
        if(validateName != null){
            return validateName;
        }
        if(validatePrice != null){
            return validatePrice;
        }
        if(validateOriginalPrice != null){
            return validateOriginalPrice;
        }
        return validateStock;
    }

    Object validateName(String name){
        if(name == null || name.trim().isEmpty()){
            return "Product name is required";
        }
        if(name.length() > 255){
            return "Product name is too long";
        }
        return null;
    }

    Object validatePrice(BigDecimal price){
        if(price == null){
            return "Product price is required";
        }
        if(price.compareTo(BigDecimal.ZERO) <= 0){
            return "Product price can't be negative";
        }
        return null;
    }

    Object validateStock(Integer stock){
        if(stock == null){
            return "Stock is required";
        }
        if(stock < 0){
            return "Stock can't be negative";
        }
        return null;
    }
}

