package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.cart.CartAddProductRequestDto;
import com.example.f02_online_shopping.dto.response.cart.CartResponseDto;
import com.example.f02_online_shopping.entity.Cart;
import com.example.f02_online_shopping.entity.CartItem;
import com.example.f02_online_shopping.entity.Product;
import com.example.f02_online_shopping.exception.ApiException;
import com.example.f02_online_shopping.repository.CartItemRepository;
import com.example.f02_online_shopping.repository.CartRepository;
import com.example.f02_online_shopping.repository.ProductRepository;
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

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Object addProductToCart(CartAddProductRequestDto requestDto) {
        Optional<Cart> cart = Optional.ofNullable(cartRepository
                        .findByUserId(requestDto.getUserId()))
                        .orElseThrow(() -> new ApiException(404, "No cart found on this user"));
        Optional<Product> product = Optional.ofNullable(productRepository
                        .findByProductId(requestDto.getProductId()))
                        .orElseThrow(() -> new ApiException(404, "No product found"));
        Optional<CartItem> optionalCartItem = cartItemRepository
                        .findByCartIdAndProductId(cart.get().getId(), requestDto.getProductId());

        CartItem cartItem = optionalCartItem.orElseGet(() -> {
            CartItem newItem = new CartItem();
            cart.ifPresent(newItem::setCart);
            product.ifPresent(newItem::setProduct);
            newItem.setQuantity(0);
            return newItem;
        });

        cartItem.setQuantity(cartItem.getQuantity() + 1);
        cartItemRepository.save(cartItem);
        return String.format("Add product with id %d to cart successfully", requestDto.getProductId());
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
                        String.format("Id: %d | Name: %s | Price: %.2f | Quantity: %d",
                                cartItem.getProduct().getId(),
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
    public Object removeProductFromCart(Integer userId, Integer productId) {
        Optional<Cart> cart = Optional.ofNullable(cartRepository
                        .findByUserId(userId))
                        .orElseThrow(() -> new ApiException(404, "No cart found on this user"));
        Optional<CartItem> cartItem = Optional.ofNullable(cartItemRepository
                        .findByCartIdAndProductId(cart.get().getId(), productId)
                        .orElseThrow(() -> new ApiException(404, "No item found on this cart")));
        cartItem.ifPresent(value -> cartItemRepository.delete(value));
        return String.format("Delete product id %d from cart of user %d successfully", productId, userId);
    }
}
