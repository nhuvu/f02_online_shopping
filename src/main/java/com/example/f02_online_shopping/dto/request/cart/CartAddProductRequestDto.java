package com.example.f02_online_shopping.dto.request.cart;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartAddProductRequestDto {
    @NotNull(message="User Id is required")
    @Positive(message = "User Id must start from 1")
    private Integer userId;

    @NotNull(message="Product Id is required")
    @Positive(message = "Product Id must start from 1")
    private Integer productId;
}
