package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.cart.CartAddProductRequestDto;
import com.example.f02_online_shopping.entity.Cart;
import com.example.f02_online_shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstant.API_V1_BASE)
public class CartController {
    @Autowired
    CartService cartService;

    /** [F12] Thêm sản phẩm vào giỏ hàng (ORM-2)
     * */
    @PostMapping(UrlConstant.CRUD_USER_CART)
    public ResponseEntity<Cart> addToCart(@RequestBody CartAddProductRequestDto requestDto) {
        return null;
    }

    /** [F13] Xem các sản phẩm có trong giỏ hàng (ORM-2)
     * */

    /** [F14] Xóa các sản phẩm có trong giỏ hàng (ORM-2)
     * */


}
