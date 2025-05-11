package com.example.f02_online_shopping.dto.response.user;

import com.example.f02_online_shopping.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String email;
    private String fullName;
    private String status;
    private String role;
    private Integer cartId;
    private List<String> order;

    public Object setError(Object object){
        return object;
    }

    public UserDto() {
    }
}
