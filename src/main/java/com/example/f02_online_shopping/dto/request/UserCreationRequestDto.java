package com.example.f02_online_shopping.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserCreationRequestDto {

    private String username;
    private String password;
    private String email;
    private String status;
    private String role;
}
