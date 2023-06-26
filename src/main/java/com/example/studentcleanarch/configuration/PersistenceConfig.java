package com.example.studentcleanarch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@Slf4j
@Configuration
@EntityScan(basePackages = "com.examples.studentcleanarch.adapter.out")
@EnableJpaRepositories(basePackages = "com.examples.studentcleanarch.adapter.out")
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class PersistenceConfig {
    public PersistenceConfig() {
        log.debug("Persistence config started");
    }

    @Bean
    AuditorAware<String> auditorProvider() {
        return () -> Optional.of("SYSTEM");
    }
}
