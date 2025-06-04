package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.cart.CartAddProductRequestDto;
import com.example.f02_online_shopping.service.CartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(UrlConstant.API_V1_BASE)
public class UserController {
    @Autowired
    CartService cartService;

    /**
     * [F12] Thêm sản phẩm vào giỏ hàng (ORM-2)
     */
    @PostMapping(UrlConstant.CRUD_USER_CART)
    public ResponseEntity<Object> addToCart(@Valid
                                            @PathVariable @Min(value = 1, message = "User Id must start from 1") Integer userId,
                                            @RequestBody CartAddProductRequestDto requestDto,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest()
                    .body(Map.of("errors", errorMessages));
        }
        requestDto.setUserId(userId);
        return ResponseEntity.ok(cartService.addProductToCart(requestDto));
    }

    /**
     * [F13] Xem các sản phẩm có trong giỏ hàng (ORM-2)
     */
    @GetMapping(UrlConstant.CRUD_USER_CART)
    public ResponseEntity<Object> getCartDetail(@Valid
                                                @PathVariable @Min(value = 1, message = "User Id must start from 1") Integer userId,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest()
                    .body(Map.of("errors", errorMessages));
        }
        return ResponseEntity.ok(cartService.viewCart(userId));
    }

    /**
     * [F14] Xóa các sản phẩm có trong giỏ hàng (ORM-2)
     */
    @DeleteMapping(UrlConstant.CRUD_CART_ITEMS)
    public ResponseEntity<Object> deleteItemsFromCart(@Valid
                                                      @PathVariable @Min(value = 1, message = "User Id must start from 1") Integer userId,
                                                      @PathVariable @Min(value = 1, message = "Product Id must start from 1") Integer productId,
                                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest()
                    .body(Map.of("errors", errorMessages));
        }
        return ResponseEntity.ok(cartService.removeProductFromCart(userId, productId));
    }
}
