package com.gft.inditex.controller;

import com.gft.inditex.api.model.PriceDto;
import com.gft.inditex.api.rest.PriceApiDelegate;
import com.gft.inditex.mapper.PriceMapperDto;
import com.gft.inditex.service.impl.PriceServiceImpl;
import com.gtf.inditex.exception.PriceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

@RestController
@Slf4j
public class PriceController implements PriceApiDelegate {

    @Autowired
    PriceServiceImpl priceService;

    @Autowired
    PriceMapperDto mapperDto;

    @Override
    public ResponseEntity<PriceDto> findPricesByParams(Date date, Integer productId, Integer brandId) {
        PriceDto result = null;
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<PriceDto> response;
        try {
            result = mapperDto.toPriceDto(priceService.findPricesByParams(date, productId, brandId));
        } catch (PriceNotFoundException e) {
            statusCode = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        if (Objects.nonNull(result)) {
            log.info(result.toString());
            response = new ResponseEntity<>(result, statusCode);
        } else {
            response = new ResponseEntity<>(statusCode);
        }
        return response;

    }
}
