package com.zegume.springbooth2jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataRepositoryTest {

    @Autowired
    DataRepository dataRepository;

    @Test
    void insertNewRecord() {
        Data data = new Data();
        data.setGIRIS_KULLA_KOD("1234567890");
        dataRepository.save(data);
    }

}
