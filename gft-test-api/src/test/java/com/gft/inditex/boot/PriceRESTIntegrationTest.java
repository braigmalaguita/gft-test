package com.gft.inditex.boot;

import com.gft.inditex.api.model.PriceDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Application.class})
@TestPropertySource(properties = { "spring.config.location=classpath:application-test.yml" })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class PriceRESTIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void caseTestData1_ok() {
        ResponseEntity<PriceDto> response = restTemplate.exchange("/price?date=2020-06-14T10:00:00Z&productId=35455&brandId=1", HttpMethod.GET, null,  PriceDto.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getId());
        Assertions.assertEquals("zara", response.getBody().getBrand().getName());
        Assertions.assertEquals(35.5, response.getBody().getPrice());
    }

    @Test
    public void caseTestData2_ok() {
        ResponseEntity<PriceDto> response = restTemplate.exchange("/price?date=2020-06-14T16:00:00Z&productId=35455&brandId=1", HttpMethod.GET, null,  PriceDto.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        Assertions.assertEquals(2, response.getBody().getId());
        Assertions.assertEquals("zara", response.getBody().getBrand().getName());
        Assertions.assertEquals(25.45, response.getBody().getPrice());
    }

    @Test
    public void caseTestData3_ok(){
        ResponseEntity<PriceDto> response = restTemplate.exchange("/price?date=2020-06-14T21:00:00Z&productId=35455&brandId=1", HttpMethod.GET, null,  PriceDto.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getId());
        Assertions.assertEquals("zara", response.getBody().getBrand().getName());
        Assertions.assertEquals(35.5, response.getBody().getPrice());
    }

    @Test
    public void caseTestData4_ok(){
        ResponseEntity<PriceDto> response = restTemplate.exchange("/price?date=2020-06-15T10:00:00Z&productId=35455&brandId=1", HttpMethod.GET, null,  PriceDto.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        Assertions.assertEquals(3, response.getBody().getId());
        Assertions.assertEquals("zara", response.getBody().getBrand().getName());
        Assertions.assertEquals(30.5, response.getBody().getPrice());
    }

    @Test
    public void caseTestData5_ok(){
        ResponseEntity<PriceDto> response = restTemplate.exchange("/price?date=2020-06-16T21:00:00Z&productId=35455&brandId=1", HttpMethod.GET, null,  PriceDto.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        Assertions.assertEquals(4, response.getBody().getId());
        Assertions.assertEquals("zara", response.getBody().getBrand().getName());
        Assertions.assertEquals(38.95, response.getBody().getPrice());
    }

    @Test
    public void PriceNotFound_OutOfDateRage() {
        ResponseEntity<PriceDto> response = restTemplate.exchange("/price?date=2021-06-16T21:00:00Z&productId=35455&brandId=1", HttpMethod.GET, null,  PriceDto.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatusCode.valueOf(404), response.getStatusCode());
    }
    @Test
    public void PriceNotFound_NoProductFound() {
        ResponseEntity<PriceDto> response = restTemplate.exchange("/price?date=2020-06-16T21:00:00Z&productId=35454&brandId=1", HttpMethod.GET, null,  PriceDto.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatusCode.valueOf(404), response.getStatusCode());
    }

    @Test(expected = Exception.class)
    public void BadRequest_InvalidDate() throws RestClientException {
        restTemplate.exchange("/price?date=2020-13-16T21:00:00Z&productId=35455&brandId=1", HttpMethod.GET, null,  PriceDto.class);
    }


}
