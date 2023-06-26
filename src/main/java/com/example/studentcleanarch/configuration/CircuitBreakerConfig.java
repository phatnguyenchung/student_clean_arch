package com.example.studentcleanarch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CircuitBreakerConfig {
    public CircuitBreakerConfig() {
        log.debug("Circuit breaker config started");
    }
}
