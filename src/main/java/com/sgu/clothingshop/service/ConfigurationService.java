package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Configuration;
import com.sgu.clothingshop.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

    private static final String VIP_PERCENT_DISCOUNT = "vipPercentDiscount";
    private static final String SUM_AMOUNT_TO_BECOME_VIP = "sumAmountToBecomeVip";

    @Autowired
    private ConfigurationRepository configurationRepository;

    public Integer getVipPercentDiscount() {
        Configuration configuration = configurationRepository.findTopByKey(VIP_PERCENT_DISCOUNT);
        if (configuration != null) {
            return Integer.parseInt(configuration.getValue());
        }
        return 0;
    }

    public Integer getSumAmoutToBecomeVip() {
        Configuration configuration = configurationRepository.findTopByKey(SUM_AMOUNT_TO_BECOME_VIP);
        if (configuration != null) {
            return Integer.parseInt(configuration.getValue());
        }
        return 0;
    }
}
