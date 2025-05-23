package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.product.ProductCreateRequestDto;
import com.example.f02_online_shopping.dto.request.product.ProductUpdateRequestDto;
import com.example.f02_online_shopping.entity.User;
import com.example.f02_online_shopping.exception.ApiException;
import com.example.f02_online_shopping.service.ProductService;
import com.example.f02_online_shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.API_V1_BASE)
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    /** [F04] Admin Xem danh sách người dùng (ORM-1)
     * */
    @GetMapping(UrlConstant.USERS)
    public ResponseEntity<Object> getAllUsers() {
        try{
            return ResponseEntity.ok(userService.getAllUsers());
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F05] Admin chặn tài khoản người dùng (ORM-1)
     * */
    @PostMapping(UrlConstant.BLOCK_USER)
    public ResponseEntity<Object> blockUser(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok(userService.blockUser(id));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F06] Admin thêm sản phẩm trong kho (ORM-1)
     * */
    @PostMapping(UrlConstant.ADMIN_PRODUCTS)
    public ResponseEntity<Object> addProduct(@RequestBody ProductCreateRequestDto requestDto) {
        try{
            return ResponseEntity.ok(productService.createProduct(requestDto));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F07] Admin sửa sản phẩm trong kho (ORM-1)
     * */
    @PostMapping(UrlConstant.CRUD_ADMIN_PRODUCTS)
    public ResponseEntity<Object> updateProduct(@RequestBody ProductUpdateRequestDto requestDto) {
        try{
            return ResponseEntity.ok(productService.updateProduct(requestDto));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F08] Admin xoá sản phẩm trong kho (ORM-1)
     * */

    /** [F09] Admin cập nhật sản phẩm trong kho (ORM-1)
     * */

    /** [F10] Admin xem danh sách sản phẩm trong kho (ORM-1)
     * */


}
