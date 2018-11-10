package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
