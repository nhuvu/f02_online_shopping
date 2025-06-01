package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.API_V1_BASE)
public class AuthenticationController {

    @Autowired
    UserService userService;

    /**
     * [F01]: User & Admin - Đăng ký: Theo email & mật khẩu (ORM-1)
     */
    @PostMapping(UrlConstant.REGISTER)
    public Object register(@Valid @RequestBody UserRegisterRequestDto request) {
        return userService.createUser(request);
    }

    /**
     * [F02]: User & Admin - Đăng nhập: Theo email & mật khẩu (ORM-1)
     */
    @PostMapping(UrlConstant.LOGIN)
    public Object login(@Valid @RequestBody UserLoginRequestDto request) {
        return userService.login(request);
    }
}
