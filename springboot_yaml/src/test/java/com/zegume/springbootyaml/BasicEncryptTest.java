package com.zegume.springbootyaml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BasicEncryptTest {

    @Autowired
    BasicEncrypt basicEncrypt;

    @Test
    void getSecret() {
        System.out.println(basicEncrypt.getSecret());
    }

}