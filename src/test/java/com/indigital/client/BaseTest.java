package com.indigital.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("staging")
public class BaseTest {

    @Test
    public void contextLoads() {
        System.out.println("EMPTY TEST");
    }

}
