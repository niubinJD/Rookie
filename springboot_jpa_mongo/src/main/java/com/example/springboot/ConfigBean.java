package com.example.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 批量绑定配置，
 */
@Component
@ConfigurationProperties(prefix = "com.nb")
public class ConfigBean {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
