package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    /*@Query("SELECT MONTH(d.product.submittedDate) , SUM(d.donGia * d.soLuong), "
            + "SUM(d.quantity), MIN(d.price), MAX(d.price), AVG(d.price) "
            + "FROM OrderDetail d GROUP BY MONTH(d.product.submittedDate) "
            + "ORDER BY MONTH(d.product.submittedDate)")
    Iterable<Object[]> revenueByMonth();*/
}
