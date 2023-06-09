package com.vizavi.application.repositories;

import com.vizavi.application.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT products.* FROM products JOIN users_products ON products.id = users_products.products.id WHERE users_products.customers_id = :productId", nativeQuery = true)
    List<Product> findProductsByUserId(@Param("productId") Long userId);
}
