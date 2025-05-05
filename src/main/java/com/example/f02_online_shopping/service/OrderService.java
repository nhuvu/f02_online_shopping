package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.model.Item;
import com.example.f02_online_shopping.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderService {
    Object createOrder(User user, List<Item> items);
}
