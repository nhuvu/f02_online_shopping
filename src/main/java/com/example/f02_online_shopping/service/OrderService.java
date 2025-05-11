package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.model.ProductModel;
import com.example.f02_online_shopping.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderService {
    Object createOrder(UserModel user, List<ProductModel> items);
}
