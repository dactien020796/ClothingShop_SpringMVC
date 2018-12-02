package com.sgu.clothingshop.repository;

import com.sgu.clothingshop.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

    Configuration findTopByKey(String key);
}
