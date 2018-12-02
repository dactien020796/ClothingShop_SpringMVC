package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Configuration;
import com.sgu.clothingshop.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

    private static final String VIP_PERCENT_DISCOUNT = "vipPercentDiscount";

    @Autowired
    private ConfigurationRepository configurationRepository;

    public Integer getVipPercentDiscount() {
        Configuration configuration = configurationRepository.findTopByKey(VIP_PERCENT_DISCOUNT);
        if (configuration != null) {
            return Integer.parseInt(configuration.getValue());
        }
        return 0;
    }
}
