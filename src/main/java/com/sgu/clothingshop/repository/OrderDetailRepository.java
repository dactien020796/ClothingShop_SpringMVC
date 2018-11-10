package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
