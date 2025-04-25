package com.example.f02_online_shopping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class L20_DemoController {

    @GetMapping("/api/v1/greeting")
    public Object getHello() {
        return "Hello shopping online project";
    }
}
