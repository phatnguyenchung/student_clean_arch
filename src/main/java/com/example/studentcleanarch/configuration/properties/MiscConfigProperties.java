package com.example.studentcleanarch.configuration.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Setter
@Getter
public class MiscConfigProperties {
    @Value("${spring.application.name}") private String appName;

    @Value("${mask_fields}") private List<String> maskFields;
}
