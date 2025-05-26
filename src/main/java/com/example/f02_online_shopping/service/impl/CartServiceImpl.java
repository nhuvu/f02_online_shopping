package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.cart.CartAddProductRequestDto;
import com.example.f02_online_shopping.dto.request.cart.CartDeleteProductRequestDto;
import com.example.f02_online_shopping.dto.response.cart.CartResponseDto;
import com.example.f02_online_shopping.entity.Cart;
import com.example.f02_online_shopping.entity.CartItem;
import com.example.f02_online_shopping.exception.ApiException;
import com.example.f02_online_shopping.repository.CartRepository;
import com.example.f02_online_shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartResponseDto addProductToCart(CartAddProductRequestDto requestDto) {

        return null;
    }

    @Override
    public CartResponseDto viewCart(Integer userId) {
        Optional<Cart> cart = Optional.ofNullable(cartRepository.findByUserId(userId))
                .orElseThrow(() -> new ApiException(404, "No cart found on this user"));
        Cart cartDetail = cart.get();
        //Build list items details
        if(!cartDetail.getCartItems().isEmpty()){
            BigDecimal totalAmount = BigDecimal.ZERO;
            List<String> cartItemDetails = new ArrayList<>();
            for(CartItem cartItem : cartDetail.getCartItems()){
                cartItemDetails.add(
                        String.format("Product: %s | Price: %.2f | Quantity: %d",
                                cartItem.getProduct().getName(),
                                cartItem.getProduct().getPrice(),
                                cartItem.getQuantity()));
                //Calculate totalAmount
                BigDecimal productPrice = cartItem.getProduct().getPrice();
                Integer quantity = cartItem.getQuantity();
                BigDecimal itemTotal = productPrice.multiply(BigDecimal.valueOf(quantity));
                totalAmount =  totalAmount.add(itemTotal);
            }
            return new CartResponseDto(
                    cartDetail.getId(),
                    cartDetail.getUser().getId(),
                    cartItemDetails,
                    totalAmount
            );
        }
        return null;
    }

    @Override
    public Object removeProductFromCart(CartDeleteProductRequestDto requestDto) {
        return null;
    }
}
