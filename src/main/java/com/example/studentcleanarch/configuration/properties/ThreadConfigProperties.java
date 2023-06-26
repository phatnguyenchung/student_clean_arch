package com.example.studentcleanarch.configuration.properties;

import com.timo.platform.configurationservice.common.ConfigAdapter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigAdapter
@ConfigurationProperties(prefix = "thread-config")
public class ThreadConfigProperties {
    private Integer corePoolSize;
    private Integer maxPoolSize;
    private Integer queueCapacity;
}
