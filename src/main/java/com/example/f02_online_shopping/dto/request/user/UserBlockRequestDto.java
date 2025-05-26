package com.example.f02_online_shopping.dto.request.user;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBlockRequestDto {
    private Integer id;
    @Builder.Default
    private String status = "BLOCK";
}
