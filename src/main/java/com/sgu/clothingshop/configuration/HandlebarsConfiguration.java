package com.sgu.clothingshop.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Handlebars configuration.
 */
@Configuration
@ConfigurationProperties("handlebars")
@Setter
@Getter
public class HandlebarsConfiguration {
    private boolean cache;
    private String prefix;
    private String suffix;
}
