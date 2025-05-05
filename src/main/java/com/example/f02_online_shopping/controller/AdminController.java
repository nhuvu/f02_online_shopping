package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.service.AdminService;
import com.example.f02_online_shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

}
