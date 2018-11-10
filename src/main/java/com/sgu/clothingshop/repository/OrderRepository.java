package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
