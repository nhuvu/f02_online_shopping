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
public class UserUpdateRequestDto {
    @NotNull(message="User Id is required")
    @Positive(message = "User Id must start from 1")
    private Integer id;

    @Email(message = "Email is invalid")
    private String email;

    @NotBlank(message = "Full name is invalid")
    @Size(message = "Full name is invalid", min = 2, max = 255)
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Full name is invalid")
    private String fullName;

    @NotBlank(message = "Password is invalid")
    @Size(message = "Password is invalid", min = 8, max = 128)
    private String password;

    @NotBlank(message = "Status is invalid")
    @Pattern(regexp = "BLOCK|ACTIVE", message = "Status must be either BLOCK or ACTIVE")
    private String status;
}
