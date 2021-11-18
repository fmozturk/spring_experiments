package com.zegume.springintegration;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Handler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void process(Data value) {
        Random random = new Random();
        long sleepInMilliseconds = random.nextInt(10000);
        logger.info("Data with {} id sleeps {} milliseconds", value.getValue(), sleepInMilliseconds);
        try {
            Thread.sleep(sleepInMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Data with {} value ends", value.getValue());
    }


}
