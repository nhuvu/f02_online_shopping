package com.example.f02_online_shopping.dto.request.cart;

import com.example.f02_online_shopping.dto.general.GenericResponseDto;
import com.example.f02_online_shopping.dto.response.cart.CartResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartUpdateRequestDto {
    private CartResponseDto cartUpdated;
    private GenericResponseDto response;
}
