package com.example.f02_online_shopping.dto.request.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequestDto {
    @Email
    private String email;

    @NotBlank(message = "Full name is invalid")
    @Size(message = "Full name is invalid", min = 2, max = 255)
    @Pattern(regexp = "^[A-Za-z ]+$")
    private String fullName;

    @NotBlank(message = "Password is invalid")
    @Size(message = "Password is invalid", min = 8, max = 128)
    private String password;
}
