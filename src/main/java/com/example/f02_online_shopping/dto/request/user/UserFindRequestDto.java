package com.example.f02_online_shopping.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserFindRequestDto {
    private Integer id;
    private String email;
}
