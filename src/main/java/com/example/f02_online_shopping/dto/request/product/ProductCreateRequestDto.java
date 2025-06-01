package com.example.f02_online_shopping.dto.request.product;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductCreateRequestDto {
    @NotBlank(message = "Product name is invalid")
    @Size(min = 1, max = 255, message = "Product name is invalid")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Product name is invalid")
    private String name;

    @NotBlank(message = "Description is invalid")
    @Size(min = 1, max = 2000, message = "Description length is invalid" )
    private String description;

    @NotNull(message="Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    @NotNull(message="Stock is required")
    @PositiveOrZero(message = "Stock must not be negative")
    private Integer stock;

    @NotNull(message="Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal originalPrice;

    @NotBlank(message = "Category is invalid")
    @Pattern(regexp = "BOOKS|ELECTRONICS|FASHION|FURNITURE|GROCERIES|HOME APPLIANCES|TOYS",
            message = "Category must be in existing list")
    private String category;
}
