package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
