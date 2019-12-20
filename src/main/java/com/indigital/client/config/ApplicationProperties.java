package com.indigital.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "client.app")
public class ApplicationProperties {

    private Integer lifeExpectancyMan;
    private Integer lifeExpectancyWoman;

}