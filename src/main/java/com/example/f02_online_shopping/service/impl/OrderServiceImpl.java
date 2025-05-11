package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.model.ProductModel;
import com.example.f02_online_shopping.model.UserModel;
import com.example.f02_online_shopping.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Object createOrder(UserModel user, List<ProductModel> items) {
        //TODO: CREATE ORDER
        return null;
    }
}
