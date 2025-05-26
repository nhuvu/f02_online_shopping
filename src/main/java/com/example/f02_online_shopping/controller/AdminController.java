package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.product.ProductCreateRequestDto;
import com.example.f02_online_shopping.dto.request.product.ProductUpdateRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserBlockRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserUpdateRequestDto;
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
    @GetMapping(UrlConstant.ADMIN_USERS)
    public ResponseEntity<Object> viewAllUsers() {
        try{
            return ResponseEntity.ok(userService.getAllUsers());
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F05] Admin chặn tài khoản người dùng (ORM-1)
     * */
    @PostMapping(UrlConstant.BLOCK_USER)
    public ResponseEntity<Object> blockUser(@RequestParam Integer id) {
        try{
            return ResponseEntity.ok(userService.blockUser(id));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F06] Admin tìm người dùng bằng email (ORM-1)
     * */
    @GetMapping(UrlConstant.SEARCH_USER)
    public ResponseEntity<Object> findUserByEmail(@RequestParam String email) {
        try{
            return ResponseEntity.ok(userService.getUserByEmail(email));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F07] Admin thêm sản phẩm trong kho (ORM-1)
     * */
    @PostMapping(UrlConstant.ADMIN_PRODUCTS)
    public ResponseEntity<Object> addProduct(@RequestBody ProductCreateRequestDto requestDto) {
        try{
            return ResponseEntity.ok(productService.createProduct(requestDto));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F08] Admin sửa sản phẩm trong kho (ORM-1)
     * */
    @PutMapping(UrlConstant.CRUD_ADMIN_PRODUCTS)
    public ResponseEntity<Object> fullUpdateProduct(@PathVariable Integer id, @RequestBody ProductUpdateRequestDto requestDto) {
        try{
            requestDto.setProductId(id);
            return ResponseEntity.ok(productService.updateProduct(requestDto));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F09] Admin xoá sản phẩm trong kho (ORM-1)
     * */
    @DeleteMapping(UrlConstant.CRUD_ADMIN_PRODUCTS)
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok(productService.deleteProduct(id));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F10] Admin cập nhật sản phẩm trong kho (ORM-1)
     * */
    @PatchMapping(UrlConstant.CRUD_ADMIN_PRODUCTS)
    public ResponseEntity<Object> partialUpdateProduct(@PathVariable Integer id, @RequestBody ProductUpdateRequestDto requestDto) {
        try{
            requestDto.setProductId(id);
            return ResponseEntity.ok(productService.updateProduct(requestDto));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F11] Admin xem danh sách sản phẩm trong kho (ORM-1)
     * */
    @GetMapping(UrlConstant.ADMIN_PRODUCTS)
    public ResponseEntity<Object> viewAllProducts() {
        try{
            return ResponseEntity.ok(productService.getAllProducts());
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

}
