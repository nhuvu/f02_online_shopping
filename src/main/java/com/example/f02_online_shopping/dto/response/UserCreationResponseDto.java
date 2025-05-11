package com.example.f02_online_shopping.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserCreationResponseDto {
    private String username;
    private String email;
    private Object error;

    public UserCreationResponseDto() {}
}
