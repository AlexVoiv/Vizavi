package com.vizavi.application.repositories;

import com.vizavi.application.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
