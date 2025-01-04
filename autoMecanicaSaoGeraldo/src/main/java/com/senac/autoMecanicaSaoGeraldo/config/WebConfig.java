package com.senac.autoMecanicaSaoGeraldo.config;

import com.senac.autoMecanicaSaoGeraldo.converter.StringToClienteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private StringToClienteConverter stringToClienteConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToClienteConverter);
    }
}
