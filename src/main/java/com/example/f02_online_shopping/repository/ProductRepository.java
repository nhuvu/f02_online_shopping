package com.example.f02_online_shopping.repository;

import com.example.f02_online_shopping.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByStockGreaterThan(Integer stockNum);

    @Query(value = "SELECT * FROM Products WHERE name = :name AND price = :price AND original_price = :originalPrice AND category = :category", nativeQuery = true)
    Product findProductByAttributes(String name, BigDecimal price, BigDecimal originalPrice, String category);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Products SET name = :name, description = :description, price = :price, stock = :stock, original_price = :originalPrice, category = :category WHERE id = :id", nativeQuery = true)
    int updateProductInfo(String name, String description, BigDecimal price, Integer stock, BigDecimal originalPrice, String category, Integer id);

    @Query(value="SELECT * FROM Products WHERE id = :id", nativeQuery = true)
    Optional<Product> findByProductId(Integer id);
}
