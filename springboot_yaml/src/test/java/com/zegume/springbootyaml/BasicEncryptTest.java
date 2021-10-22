package com.zegume.springbootyaml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BasicEncryptTest {

    @Autowired
    BasicEncrypt basicEncrypt;

    @Test
    void getSecret() {
        assertEquals("database_password", basicEncrypt.getSecret());
    }

}