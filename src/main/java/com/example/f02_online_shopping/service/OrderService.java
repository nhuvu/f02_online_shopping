package com.example.f02_online_shopping.service;

import com.example.f02_online_shopping.dto.request.order.OrderUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.order.OrderResponseDto;
import com.example.f02_online_shopping.model.ProductModel;
import com.example.f02_online_shopping.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderService {
    //Place order
    Object createOrder(UserModel user, List<ProductModel> items);

    //View order list
    List<OrderResponseDto> getOrders(Integer userId);

    //Search order by id
    OrderResponseDto getOrderById(Integer orderId);

    //Edit order
    OrderResponseDto updateOrder(OrderUpdateRequestDto requestDto);

    //Cancel order
    OrderResponseDto cancelOrder(Integer orderId);

    //View order history

}
