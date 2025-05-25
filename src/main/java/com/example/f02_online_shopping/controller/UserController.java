package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.user.UserUpdateRequestDto;
import com.example.f02_online_shopping.exception.ApiException;
import com.example.f02_online_shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.API_V1_BASE)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(UrlConstant.USER_PROFILE)
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
        try{
           return ResponseEntity.ok(userService.getUserById(id));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    @PutMapping (UrlConstant.CRUD_USER)
    public ResponseEntity<Object> updateUser(@RequestBody UserUpdateRequestDto request, @PathVariable Integer id) {
        try{
            request.setId(id);
            return ResponseEntity.ok(userService.updateUser(request));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }
}
