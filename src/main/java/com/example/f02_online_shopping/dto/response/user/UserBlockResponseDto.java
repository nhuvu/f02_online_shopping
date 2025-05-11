package com.example.f02_online_shopping.dto.response.user;

import com.example.f02_online_shopping.dto.general.GenericResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBlockResponseDto {
    private Integer userIdBlocked;
    private GenericResponseDto response;
}
