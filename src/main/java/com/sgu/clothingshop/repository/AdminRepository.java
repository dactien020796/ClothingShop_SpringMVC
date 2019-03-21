package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findTopByUsername(String username);
}
