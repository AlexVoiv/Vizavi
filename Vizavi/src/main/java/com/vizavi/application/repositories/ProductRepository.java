package com.vizavi.application.repositories;

import com.vizavi.application.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByNameAndTypeAndPrice(String name, String type, double price);
}

