package com.example.f02_online_shopping.dto.request.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestDto {
    private String email;
    private String fullName;
    private String password;
}
