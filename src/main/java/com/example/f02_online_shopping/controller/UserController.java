package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserUpdateRequestDto;
import com.example.f02_online_shopping.exception.ApiException;
import com.example.f02_online_shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(UrlConstant.API_V1_USER_REGISTER)
    public ResponseEntity<Object> register(@RequestBody UserRegisterRequestDto request) {
        try{
            return ResponseEntity.ok(userService.registerUser(request));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }

    }

    @GetMapping(UrlConstant.API_V1_USER_FIND_BY_ID)
    public ResponseEntity<Object> getUserById(@PathVariable Integer userId) {
        try{
           return ResponseEntity.ok(userService.getUserById(userId));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    @PutMapping (UrlConstant.API_V1_USER_UPDATE)
    public ResponseEntity<Object> updateUser(@RequestBody UserUpdateRequestDto request, @PathVariable Integer userId) {
        try{
            request.setId(userId);
            return ResponseEntity.ok(userService.updateUser(request));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }



}
