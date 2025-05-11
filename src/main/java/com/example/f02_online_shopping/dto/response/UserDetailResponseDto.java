package com.example.f02_online_shopping.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDetailResponseDto {
    private Integer id;
    private String email;
    private String status;
    private String role;
    private Integer cartId;
    private List<String> orderDetails;

    public UserDetailResponseDto(String email, Integer id, String status, String role, Integer cartId, List<String> orderDetails) {
        this.email = email;
        this.id = id;
        this.status = status;
        this.role = role;
        this.cartId = cartId;
        this.orderDetails = orderDetails;
    }

    public UserDetailResponseDto(String email, Integer id, String status, String role) {
        this.email = email;
        this.id = id;
        this.status = status;
        this.role = role;
    }

}
