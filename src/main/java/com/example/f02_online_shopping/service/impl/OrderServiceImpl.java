package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.model.Item;
import com.example.f02_online_shopping.model.User;
import com.example.f02_online_shopping.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Object createOrder(User user, List<Item> items) {
        //TODO: CREATE ORDER
        return null;
    }
}
