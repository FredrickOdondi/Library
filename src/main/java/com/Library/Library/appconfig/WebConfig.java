package com.Library.Library.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow all paths
                        .allowedOrigins("http://localhost:63342") // Allow requests from this origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE"); // Allow these HTTP methods
            }
        };
    }
}