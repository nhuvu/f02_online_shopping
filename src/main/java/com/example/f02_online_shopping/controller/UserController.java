package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.cart.CartAddProductRequestDto;
import com.example.f02_online_shopping.dto.request.cart.CartDeleteProductRequestDto;
import com.example.f02_online_shopping.exception.ApiException;
import com.example.f02_online_shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.API_V1_BASE)
public class UserController {
    @Autowired
    CartService cartService;

    /** [F12] Thêm sản phẩm vào giỏ hàng (ORM-2)
     * */
    @PutMapping(UrlConstant.CRUD_USER_CART)
    public ResponseEntity<Object> addToCart(@PathVariable Integer id, @RequestBody CartAddProductRequestDto requestDto) {
        try{
            requestDto.setUserId(id);
            return ResponseEntity.ok(cartService.addProductToCart(requestDto));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F13] Xem các sản phẩm có trong giỏ hàng (ORM-2)
     * */
    @GetMapping(UrlConstant.USER_CART)
    public ResponseEntity<Object> getCartDetail(@RequestParam Integer userId) {
        try{
            return ResponseEntity.ok(cartService.viewCart(userId));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F14] Xóa các sản phẩm có trong giỏ hàng (ORM-2)
     * */
    @DeleteMapping(UrlConstant.CRUD_USER_CART)
    public ResponseEntity<Object> deleteItemsFromCart(@RequestBody CartDeleteProductRequestDto requestDto) {
        try{
            return ResponseEntity.ok(cartService.removeProductFromCart(requestDto));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

}
