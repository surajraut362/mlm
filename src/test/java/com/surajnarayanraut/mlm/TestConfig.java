package com.surajnarayanraut.mlm;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
