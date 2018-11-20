package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Email;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findCustomerByEmail(String email);
}
