package com.example.eureka_service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Value("${custom.greeting}")
    private String greeting;

    @PostConstruct
    public void init() {
        // This method will be called after the bean is initialized
        System.out.println("----------------- Config value at startup: " + greeting + "<>><><><>><><><><><><><><>><><><><>");
    }
}
