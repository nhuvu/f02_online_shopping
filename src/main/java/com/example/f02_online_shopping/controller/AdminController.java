package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.product.ProductCreateRequestDto;
import com.example.f02_online_shopping.dto.request.product.ProductUpdateRequestDto;
import com.example.f02_online_shopping.service.ProductService;
import com.example.f02_online_shopping.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.API_V1_BASE)
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    /**
     * [F04] Admin Xem danh sách người dùng (ORM-1)
     */
    @GetMapping(UrlConstant.ADMIN_USERS)
    public Object viewAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * [F05] Admin chặn tài khoản người dùng (ORM-1)
     */
    @PostMapping(UrlConstant.BLOCK_USER)
    public Object blockUser(@Valid
                            @PathVariable @NotNull @Min(value = 1, message = "User Id must start from 1") Integer userId) {
        return userService.blockUser(userId);
    }

    /**
     * [F06] Admin tìm người dùng bằng email (ORM-1)
     */
    @GetMapping(UrlConstant.SEARCH_USER)
    public Object findUserByEmail(@Valid
                                  @RequestParam @NotNull @Email(message = "Email is not valid") String email) {
        return userService.getUserByEmail(email);
    }

    /**
     * [F07] Admin thêm sản phẩm trong kho (ORM-1)
     */
    @PostMapping(UrlConstant.ADMIN_PRODUCTS)
    public Object addProduct(@Valid @RequestBody ProductCreateRequestDto requestDto) {
        return productService.createProduct(requestDto);
    }

    /**
     * [F08] Admin sửa sản phẩm trong kho (ORM-1)
     */
    @PutMapping(UrlConstant.CRUD_ADMIN_PRODUCTS)
    public Object fullUpdateProduct(@Valid
                                    @PathVariable @NotNull @Min(value = 1, message = "Product Id must start from 1") Integer productId,
                                    @RequestBody ProductUpdateRequestDto requestDto) {
        requestDto.setProductId(productId);
        return productService.updateProduct(requestDto);
    }

    /**
     * [F09] Admin xoá sản phẩm trong kho (ORM-1)
     */
    @DeleteMapping(UrlConstant.CRUD_ADMIN_PRODUCTS)
    public Object deleteProduct(@Valid
                                @PathVariable @NotNull @Min(value = 1, message = "Product Id must start from 1") Integer productId) {
        return productService.deleteProduct(productId);
    }

    /**
     * [F10] Admin cập nhật sản phẩm trong kho (ORM-1)
     */
    @PatchMapping(UrlConstant.CRUD_ADMIN_PRODUCTS)
    public Object partialUpdateProduct(@Valid
                                       @PathVariable @NotNull @Min(value = 1, message = "Product Id must start from 1") Integer productId
            , @RequestBody ProductUpdateRequestDto requestDto) {
        requestDto.setProductId(productId);
        return productService.updateProduct(requestDto);
    }

    /**
     * [F11] Admin xem danh sách sản phẩm trong kho (ORM-1)
     */
    @GetMapping(UrlConstant.ADMIN_PRODUCTS)
    public Object viewAllProducts() {
        return productService.getAllProducts();
    }
}
