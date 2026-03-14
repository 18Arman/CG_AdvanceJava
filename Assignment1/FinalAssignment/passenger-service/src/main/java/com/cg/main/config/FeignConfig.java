package com.cg.main.config;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    // Sets Feign logging level to FULL so you can see request/response in logs
    // Levels: NONE, BASIC, HEADERS, FULL
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}