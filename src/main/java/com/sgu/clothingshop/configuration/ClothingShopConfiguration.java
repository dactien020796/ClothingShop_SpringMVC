package com.sgu.clothingshop.configuration;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import com.sgu.clothingshop.configuration.HandlebarsConfiguration;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;

/**
 * Project configuration.
 */
@Configuration
public class ClothingShopConfiguration {

    @Autowired
    private HandlebarsConfiguration handlebarsConfiguration;

    @Bean
    public ViewResolver viewResolver() {
        HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();
        viewResolver.setCache(handlebarsConfiguration.isCache());
        viewResolver.setPrefix(handlebarsConfiguration.getPrefix());
        viewResolver.setSuffix(handlebarsConfiguration.getSuffix());

        viewResolver.registerHelper("add", new Helper<Object>() {
            @Override
            public Object apply(Object context, Options options) throws IOException {
                return (Integer) options.param(0) + (Integer) options.param(1);
            }
        });

        viewResolver.registerHelper("equal", new Helper<Object>() {
            @Override
            public Object apply(Object context, Options options) throws IOException {
                return options.param(0)
                        .equals(options.param(1)) ? options.fn(context) : options.inverse(context);
            }
        });

        return viewResolver;
    }
}
