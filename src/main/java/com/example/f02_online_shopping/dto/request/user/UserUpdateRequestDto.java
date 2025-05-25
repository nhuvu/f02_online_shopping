package com.example.f02_online_shopping.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDto {
    private Integer id;
    private String email;
    private String fullName;
    private String password;
    private String status;
}
