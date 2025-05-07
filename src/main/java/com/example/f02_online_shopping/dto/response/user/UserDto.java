package com.example.f02_online_shopping.dto.response.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String email;
    private String fullName;
    private String status;
    private String role;

    public Object setError(Object object){
        return object;
    }
}
