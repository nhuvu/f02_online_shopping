package com.example.f02_online_shopping.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
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

    public UserResponseDto(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    public UserResponseDto(Integer id, String email, String fullName) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
    }
}
