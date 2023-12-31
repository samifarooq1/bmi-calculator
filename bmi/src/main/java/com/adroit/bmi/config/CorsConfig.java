package com.adroit.bmi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	 registry.addMapping("/api/bmi/**")
         .allowedOrigins("http://localhost:8001")
         .allowedMethods("GET", "POST", "PUT", "DELETE")
         //.allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
         .allowCredentials(true);
    	/*
        registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowCredentials(true);*/
    }
}
