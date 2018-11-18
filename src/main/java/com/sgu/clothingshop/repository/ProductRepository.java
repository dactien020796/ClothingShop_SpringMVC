package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Iterable<Product> findAllByIsDeleted(Boolean isDelete);
}
