package com.example.Medical.App.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Autorisation de toutes les routes
                .allowedOrigins("http://localhost:4200") // URL de mon frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes autorisées
                .allowedHeaders("*"); // Autorisation de tous les en-têtes
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        // Les fichiers enregistrés dans le dossier "uploads/patients/" seront accessibles via "/images/**"
        registry.addResourceHandler("/image/**").addResourceLocations("files:uploads/patients/");

    }
}