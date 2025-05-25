package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.order.OrderUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.order.OrderResponseDto;
import com.example.f02_online_shopping.model.ProductModel;
import com.example.f02_online_shopping.model.UserModel;
import com.example.f02_online_shopping.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Object createOrder(UserModel user, List<ProductModel> items) {
        return null;
    }

    @Override
    public List<OrderResponseDto> getOrders(Integer userId) {
        return List.of();
    }

    @Override
    public OrderResponseDto getOrderById(Integer orderId) {
        return null;
    }

    @Override
    public OrderResponseDto updateOrder(OrderUpdateRequestDto requestDto) {
        return null;
    }

    @Override
    public OrderResponseDto cancelOrder(Integer orderId) {
        return null;
    }
}
