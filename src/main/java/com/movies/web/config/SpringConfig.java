package com.movies.web.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
public class SpringConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
