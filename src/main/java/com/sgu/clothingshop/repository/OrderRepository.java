package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    //Iterable<Order> findAllByCustomerId(String customerId);
}
