package com.gft.inditex.controller;

import com.gft.inditex.api.model.PriceDto;
import com.gft.inditex.boot.Application;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerIntTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void whenValidInput_thenCreateEmployee() throws Exception {
        ResponseEntity<PriceDto> response = restTemplate.exchange("/price?date=2020-06-15T19:32:28Z&productId=35455&brandId=1", HttpMethod.GET, null,  PriceDto.class);

        Assertions.assertNotNull(response);
    }
}
