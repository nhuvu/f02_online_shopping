package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.exception.ApiException;
import com.example.f02_online_shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.API_V1_BASE)
public class AuthenticationController {

    @Autowired
    UserService userService;

    /** [F01]: User & Admin
     * Đăng ký: Theo email & mật khẩu (ORM-1)
     * */
    @PostMapping(UrlConstant.REGISTER)
    public Object register(@RequestBody UserRegisterRequestDto request){
        try{
            return ResponseEntity.ok(userService.registerUser(request));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    /** [F02]: User & Admin
     * Đăng nhập: Theo email & mật khẩu (ORM-1)
     * */
    @PostMapping(UrlConstant.LOGIN)
    public Object login(@RequestBody UserLoginRequestDto request){
        try{
            return ResponseEntity.ok(userService.login(request));
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }    }


}
