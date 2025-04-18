package com.example.ticket_service.config;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${owner.name}")
    private String ownerName;

    @PostConstruct
    public void init() {
        // This method will be called after the bean is initialized
        System.out.println("----------------- Config value at startup: " + ownerName + "<>><><><>><><><><><><><><>><><><><>");
    }
}
