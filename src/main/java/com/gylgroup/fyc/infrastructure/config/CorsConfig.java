package com.gylgroup.fyc.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")              // Aplica a todos los endpoints
                        .allowedOrigins("http://localhost:5173") // Origen permitido
                        .allowedMethods("*")          // Permite todos los métodos (GET, POST, etc.)
                        .allowedHeaders("*");         // Permite todos los headers
            }
        };
    }
}

