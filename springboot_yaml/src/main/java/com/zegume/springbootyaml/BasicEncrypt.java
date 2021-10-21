package com.zegume.springbootyaml;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BasicEncrypt {

    private String password = "default";

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecret() {
        return password;
    }

}
