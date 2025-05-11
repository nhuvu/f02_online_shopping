package com.example.f02_online_shopping.dto.request.cart;

import com.example.f02_online_shopping.dto.general.GenericResponseDto;
import com.example.f02_online_shopping.dto.response.cart.CartDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartUpdateRequestDto {
    private CartDto cartUpdated;
    private GenericResponseDto response;
}
