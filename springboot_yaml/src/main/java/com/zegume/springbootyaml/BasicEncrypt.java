package com.zegume.springbootyaml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "basicencrypt")
public class BasicEncrypt {

    private String password = "default";

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecret() {
        return password;
    }

}
