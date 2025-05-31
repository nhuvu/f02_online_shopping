package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.cart.CartAddProductRequestDto;
import com.example.f02_online_shopping.dto.request.cart.CartUpdateRequestDto;
import com.example.f02_online_shopping.service.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.API_V1_BASE)
public class UserController {
    @Autowired
    CartService cartService;

    /**
     * [F12] Thêm sản phẩm vào giỏ hàng (ORM-2)
     */
    @PostMapping(UrlConstant.CRUD_USER_CART)
    public Object addToCart(@PathVariable Integer userId,
                            @Valid @RequestBody CartAddProductRequestDto requestDto) {
        requestDto.setUserId(userId);
        return cartService.addProductToCart(requestDto);
    }

    /**
     * [F13] Xem các sản phẩm có trong giỏ hàng (ORM-2)
     */
    @GetMapping(UrlConstant.CRUD_USER_CART)
    public Object getCartDetail(@PathVariable Integer userId) {
        return cartService.viewCart(userId);
    }

    /**
     * [F14] Xóa các sản phẩm có trong giỏ hàng (ORM-2)
     */
    @DeleteMapping(UrlConstant.CRUD_CART_ITEMS)
    public Object deleteItemsFromCart(@PathVariable Integer userId, @PathVariable Integer productId){
        return cartService.removeProductFromCart(userId, productId);
    }
}
