package com.example.f02_online_shopping.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequestDto {
    @Email
    private String email;

    @NotBlank(message = "Password is invalid")
    @Size(message = "Password is invalid", min = 8, max = 128)
    private String password;
}
