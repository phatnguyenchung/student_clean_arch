package com.example.studentcleanarch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@Slf4j
@Configuration
@EnableRetry
public class RetryConfig {
    public RetryConfig() {
        log.debug("Retry config started");
    }
}
