package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Iterable<Product> findAllByIsDeleted(Boolean isDelete);

    Iterable<Product> findAllByBrandIdAndIsDeleted(Long brandId, Boolean isDelete);

    Iterable<Product> findAllByCategoryIdAndIsDeleted(Long categoryId, Boolean isDelete);

    Iterable<Product> findAllByNameContaining(String name);
}
