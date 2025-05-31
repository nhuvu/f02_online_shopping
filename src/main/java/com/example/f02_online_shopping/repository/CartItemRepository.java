package com.example.f02_online_shopping.repository;

import com.example.f02_online_shopping.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    @Query(value = "SELECT * FROM Cart_Items WHERE cart_id = :cartId AND product_id = :productId", nativeQuery = true)
    Optional<CartItem> findByCartIdAndProductId(Integer cartId, Integer productId);
}
